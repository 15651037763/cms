package com.pf.org.cms.service.impl;

import com.pf.org.cms.service.BaseServiceClient;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Auther: pf
 * @Date: 2018/2/1 19:58
 * @Description:
 */
@Service(value = "baseServie")
public class BaseServiceClientImpl implements BaseServiceClient {
    //分批保存阀值
    private int count = 1000;

    private static final Logger log = LoggerFactory.getLogger(BaseServiceClientImpl.class);

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int batchInsert(String sqlId, List data) {
        /*通用批量保存，事务内每count条分批commit*/
        if (data.isEmpty() || StringUtils.isEmpty(sqlId)) {
            log.info("批量保存出错，mapperIndex或data为空");
            return 0;
        }
        int result = 0, index = 0;
        SqlSession batchSqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        int lastIndex = count;
        try {
            while (index < data.size()) {
                if (data.size() <= lastIndex) {
                    lastIndex = data.size();
                    result = result + batchSqlSession.insert(sqlId, data.subList(index, lastIndex));
                    batchSqlSession.commit();
                    log.info(new StringBuilder("已保存[").append(index).append("--").append(lastIndex - 1).append("}条数据").toString());
                    // 批量保存结束，退出循环
                    break;
                } else {
                    result = result + batchSqlSession.insert(sqlId, data.subList(index, lastIndex));
                    batchSqlSession.commit();
                    log.info(new StringBuilder("已保存[").append(index).append("--").append(lastIndex - 1).append("}条数据").toString());
                    // 设置下一批
                    index = lastIndex;
                    lastIndex = lastIndex + count;
                }
            }
        } catch (Exception e) {
            if (null != batchSqlSession) {
                batchSqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (null != batchSqlSession) {
                batchSqlSession.close();
            }
        }
        return result;
    }

}
