package com.pf.org.cms.service.impl;

import com.pf.org.cms.entity.UserInfo;
import com.pf.org.cms.entity.UserRoleInfo;
import com.pf.org.cms.mapper.UserInfoMapper;
import com.pf.org.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

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
}
