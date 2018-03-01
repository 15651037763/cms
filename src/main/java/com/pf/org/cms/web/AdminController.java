package com.pf.org.cms.web;

import com.alibaba.fastjson.JSONObject;
import com.pf.org.cms.common.IConstants;
import com.pf.org.cms.entity.JsonBean;
import com.pf.org.cms.entity.UserInfo;
import com.pf.org.cms.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Auther: pf
 * @Date: 2017/12/19 11:52
 * @Description:
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/testAuthorization")
    @ApiOperation(value = "test", notes = "测试admin访问权限")
    public String testAuthorization() {
        return "你拥有admin访问权限";
    }

    @ApiOperation(value = "getUser", notes = "管理员接口获取用户")
    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public String getUser(@RequestParam long id) {
        JsonBean reData = new JsonBean();
        Map user = userService.getUserInfo(id);
        reData.setStatus(IConstants.RESULT_INT_SUCCESS);
        reData.setMessage("查询成功");
        reData.setData(user);
        return JSONObject.toJSONString(reData);
    }

    @ApiOperation(value = "addUser", notes = "管理员接口新增用户")
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public String addUser(@RequestParam String user) {
        JsonBean reData = new JsonBean();
        UserInfo userInfo = (UserInfo) JSONObject.parseObject(user, UserInfo.class);
        if (userService.addUserInfo(userInfo)) {
            reData.setStatus(IConstants.RESULT_INT_SUCCESS);
            reData.setMessage("新增成功");
        } else {
            reData.setStatus(IConstants.RESULT_INT_ERROR);
            reData.setMessage("新增失败");
        }
        return JSONObject.toJSONString(reData);
    }

    @ApiOperation(value = "updateUser", notes = "管理员接口更新用户")
    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public String updateUser(@RequestParam String user) {
        JsonBean reData = new JsonBean();
        UserInfo userInfo = (UserInfo) JSONObject.parseObject(user, UserInfo.class);
        if (userService.updateUserInfo(userInfo)) {
            reData.setStatus(IConstants.RESULT_INT_SUCCESS);
            reData.setMessage("更新成功");
        } else {
            reData.setStatus(IConstants.RESULT_INT_ERROR);
            reData.setMessage("更新失败");
        }
        return JSONObject.toJSONString(reData);
    }

    @ApiOperation(value = "delUser", notes = "管理员接口删除用户")
    @RequestMapping(method = RequestMethod.DELETE, value = "/user")
    public String delUser(@RequestParam long id) {
        JsonBean reData = new JsonBean();
        if (userService.deleteUserInfo(id)) {
            reData.setStatus(IConstants.RESULT_INT_SUCCESS);
            reData.setMessage("删除成功");
        } else {
            reData.setStatus(IConstants.RESULT_INT_ERROR);
            reData.setMessage("删除失败");
        }
        return JSONObject.toJSONString(reData);
    }
}
