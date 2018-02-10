package com.pf.org.cms.service;

import com.pf.org.cms.entity.UserInfo;
import com.pf.org.cms.entity.UserRoleInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 批量获取用户信息
     *
     * @param paramMap
     * @return List<UserInfo>
     */
    public List<UserInfo> getUserInfos(Map<String, Object> paramMap);

    /**
     * 获取用户角色信息
     *
     * @param paramMap
     * @return List<UserRoleInfo>
     */
    public List<UserRoleInfo> getUserRoleInfos(Map<String, Object> paramMap);

    /**
     * 新增用户信息
     *
     * @param userInfo
     */
    public void addUserInfo(UserInfo userInfo);

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    public HashMap getUserInfo(long id);

    /**
     * 更新用户信息
     *
     * @param userInfo
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param id
     */
    public void deleteUserInfo(long id);
}
