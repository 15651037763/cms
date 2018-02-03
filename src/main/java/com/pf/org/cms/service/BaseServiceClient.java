package com.pf.org.cms.service;

import java.util.List;

/**
 * @Auther: pf
 * @Date: 2018/2/1 19:50
 * @Description:
 */
public interface BaseServiceClient {
    /**
     * 通用批量保存
     *
     * @param sqlId
     * @param data
     * @return
     */
    public int batchInsert(String sqlId, List data);
}
