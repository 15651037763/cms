package com.pf.org.cms.service.impl;

import com.pf.org.cms.entity.UserInfo;
import com.pf.org.cms.entity.UserRoleInfo;
import com.pf.org.cms.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void getUserInfos() throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userCode", "17040406");
        List<UserInfo> res = userService.getUserInfos(paramMap);
        System.out.println(res.toString());
    }

    @Test
    public void getUserRoleInfos() throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("userCode", "17040406");
        List<UserRoleInfo> res = userService.getUserRoleInfos(paramMap);
        System.out.println(res.toString());
    }

    @Test
    public void addUserInfos() throws Exception {
        UserInfo u1 = new UserInfo();
        u1.setUserCode("112233");
        u1.setUserName("测试名字");
        u1.setUserPwd("111000");
        u1.setCreateBy("mko1");
        u1.setCreateDate(new Date());
        u1.setSortNo(99);
        u1.setState(1);
        userService.addUserInfo(u1);
    }

    @Test
    public void getUserInfo() {
        HashMap m = userService.getUserInfo(1L);
        System.out.println(m.toString());
    }

    @Test
    public void updateUserInfo() {}

    @Test
    public void deleteUserInfo() {
        userService.deleteUserInfo(3L);
    }

}
