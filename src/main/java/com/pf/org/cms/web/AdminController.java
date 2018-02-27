package com.pf.org.cms.web;

import com.pf.org.cms.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Auther: pf
 * @Date: 2017/12/19 11:52
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/testAuthorization")
    @ApiOperation(value = "test", notes = "测试admin访问权限")
    public String testAuthorization() {
        return "你拥有admin访问权限";
    }

    @ApiOperation(value = "getUser", notes = "管理员接口获取用户")
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public Map getUser(@RequestParam long userId) {
        return userService.getUserInfo(userId);
    }

    @ApiOperation(value = "addUser", notes = "管理员接口新增用户")
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public Map addUser(@RequestParam long userId) {
        return userService.getUserInfo(userId);
    }

    @ApiOperation(value = "updateUser", notes = "管理员接口更新用户")
    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public Map updateUser(@RequestParam long userId) {
        return userService.getUserInfo(userId);
    }

    @ApiOperation(value = "delUser", notes = "管理员接口删除用户")
    @RequestMapping(method = RequestMethod.DELETE, value = "/user")
    public Map delUser(@RequestParam long userId) {
        return userService.getUserInfo(userId);
    }
}
