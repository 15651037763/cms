package com.pf.org.cms.mapper;

import com.pf.org.cms.entity.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    List<UserInfo> getUserInfos(Map<String, Object> paramMap);
}
