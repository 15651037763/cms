package com.pf.org.cms.service;

import com.pf.org.cms.entity.UserInfo;
import com.pf.org.cms.entity.UserRoleInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 获取用户信息
     * @param paramMap
     * @return List<UserInfo>
     */
    public List<UserInfo> getUserInfos(Map<String, Object> paramMap);

    /**
     * 获取用户角色信息
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    public List<UserRoleInfo> getUserRoleInfos(Map<String, Object> paramMap);
}
