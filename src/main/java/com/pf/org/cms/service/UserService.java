package com.pf.org.cms.service;

import com.pf.org.cms.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 获取用户信息
     * @param paramMap
     * @return
     */
    public List<UserInfo> getUserInfos(Map<String, Object> paramMap);
}
