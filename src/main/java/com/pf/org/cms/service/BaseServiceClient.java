package com.pf.org.cms.service;

import java.util.List;

/**
 * @Auther: pf
 * @Date: 2018/2/1 19:50
 * @Description:
 */
public interface BaseServiceClient {
    /**
     * 保存
     * @param obj
     * @return
     */
    public int insert(Object obj);

    /**
     * 根据long型主键查询
     * @param id
     * @param c
     * @param <T>
     * @return
     */
    public <T> T query(int id, Class<T> c);

    /**
     * 根据主键更新
     * @param obj
     * @return
     */
    public int update(Object obj);

    /**
     * 根据主键删除
     * @param obj
     * @return
     */
    public int delete(Object obj);

    /**
     * 通用批量保存
     *
     * @param sqlId
     * @param data
     * @return
     */
    public int batchInsert(String sqlId, List data);

}
