package com.pf.org.cms.service.impl;

import com.pf.org.cms.entity.UserInfo;
import com.pf.org.cms.entity.UserRoleInfo;
import com.pf.org.cms.mapper.UserInfoMapper;
import com.pf.org.cms.service.BaseServiceClient;
import com.pf.org.cms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private BaseServiceClient baseServiceClient;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserInfo> getUserInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userInfoMapper.getUserInfos(paramMap);
    }

    @Override
    public List<UserRoleInfo> getUserRoleInfos(Map<String, Object> paramMap) {
        paramMap.put("state", 1);
        return userInfoMapper.getUserRoleInfos(paramMap);
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        baseServiceClient.insert(userInfo);
    }

    @Override
    public HashMap getUserInfo(long id) {
        return baseServiceClient.query(id, UserInfo.class);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return baseServiceClient.update(userInfo);
    }

    @Override
    public void deleteUserInfo(long id) {
        UserInfo user = new UserInfo();
        user.setId(id);
        baseServiceClient.delete(user);
    }

}
