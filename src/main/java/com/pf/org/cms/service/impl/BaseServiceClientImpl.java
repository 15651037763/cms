package com.pf.org.cms.service.impl;

import com.pf.org.cms.annotation.Column;
import com.pf.org.cms.annotation.Id;
import com.pf.org.cms.annotation.Table;
import com.pf.org.cms.mapper.BaseMapper;
import com.pf.org.cms.service.BaseServiceClient;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private BaseMapper baseMapper;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    private Map<String, Object> transformObj(Object t) {
        //获取表名
        if (null == t.getClass().getAnnotation(Table.class)) {
            throw new RuntimeException("Error Input Object! Error @Table Annotation.");
        }
        Map<String, Object> re = new HashMap<String, Object>();
        re.put("TABLE_NAME", t.getClass().getAnnotation(Table.class).value());

        Method[] m = t.getClass().getMethods();
        if (null == m || m.length <= 0) {
            throw new RuntimeException("Error Input Object! No Method.");
        }

        List k = new ArrayList();//存放列名
        List v = new ArrayList();//存放列值
        for (Method i : m) {
            //获取列名和值
            try {
                if (null != i.getAnnotation(Column.class)) {
                    k.add(i.getAnnotation(Column.class).value());
                    v.add(i.invoke(t, null));
                    continue;
                }
                if (null != i.getAnnotation(Id.class)) {
                    re.put("KEY_ID", i.getAnnotation(Id.class).value());
                    re.put("KEY_VALUE", i.invoke(t, null));
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Error Input Object! Error Invoke Get Method.", e);
            }
        }
        re.put("COLUMNS", k);
        re.put("VALUES", v);
        if (k.size() != v.size()) {
            throw new RuntimeException("Error Input Object! Internal Error.");
        }
        return re;
    }

    @Override
    public int insert(Object obj) {
        Map<String, Object> params = transformObj(obj);
        log.info(new StringBuffer("Function Insert.Transformed Params:").append(params).toString());
        return baseMapper.insert(params);
    }

    @Override
    public HashMap query(long id, Class c) {
        Map<String, Object> params = new HashMap<>();
        try {
            params = transformObj(c.newInstance());
            log.info(new StringBuffer("Function Query.Transformed Params:").append(params).toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (null == params.get("KEY_ID")) {
            throw new RuntimeException("主键为空");
        }
        params.put("KEY_VALUE", id);
        return baseMapper.queryForObject(params);
    }

    @Override
    public int update(Object obj) {
        Map<String, Object> params = transformObj(obj);
        log.info(new StringBuffer("Function Update.Transformed Params:").append(params).toString());
        if (null == params.get("KEY_ID") || null == params.get("KEY_VALUE")) {
            throw new RuntimeException("主键或主键值为空");
        }
        return baseMapper.update(params);
    }

    @Override
    public int delete(Object obj) {
        Map<String, Object> params = transformObj(obj);
        log.info(new StringBuffer("Function Delete.Transformed Params:").append(params).toString());
        if (null == params.get("KEY_ID") || null == params.get("KEY_VALUE")) {
            throw new RuntimeException("主键或主键值为空");
        }
        return baseMapper.delete(params);
    }

    @Override
    public int batchInsert(String sqlId, List data) {
        /*通用批量保存，事务内每count条分批commit*/
        if (data.isEmpty() || StringUtils.isEmpty(sqlId)) {
            log.info("批量保存出错，mapperIndex或data为空");
            return 0;
        }
        int result = 0, index = 0;
        SqlSession sqlSession = this.sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH);
        int lastIndex = count;
        try {
            while (index < data.size()) {
                if (data.size() <= lastIndex) {
                    lastIndex = data.size();
                    result = result + sqlSession.insert(sqlId, data.subList(index, lastIndex));
                    sqlSession.commit();
                    log.info(new StringBuilder("已保存[").append(index).append("--").append(lastIndex - 1).append("}条数据").toString());
                    // 批量保存结束，退出循环
                    break;
                } else {
                    result = result + sqlSession.insert(sqlId, data.subList(index, lastIndex));
                    sqlSession.commit();
                    log.info(new StringBuilder("已保存[").append(index).append("--").append(lastIndex - 1).append("}条数据").toString());
                    // 设置下一批
                    index = lastIndex;
                    lastIndex = lastIndex + count;
                }
            }
        } catch (Exception e) {
            if (null != sqlSession) {
                sqlSession.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
        return result;
    }

}
