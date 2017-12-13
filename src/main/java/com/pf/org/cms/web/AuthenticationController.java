package com.pf.org.cms.web;

import com.pf.org.cms.entity.JsonBean;
import com.pf.org.cms.utils.ParamUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: pf
 * @Date: 2017/12/12 19:41
 * @Description:
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @RequestMapping(value = "/login")
    public String login() {
        return "/login";
    }

    @ResponseBody
    @RequestMapping(value = "/login_in", produces = "application/json;charset=UTF-8")
    public JsonBean loginIn(HttpServletRequest request) {
        JsonBean reJson = new JsonBean();
        Map paramMap = ParamUtils.handleServletParameter(request);
        String userCode = MapUtils.getString(paramMap, "userCode");
        String userPwd = MapUtils.getString(paramMap, "userPwd");
        // shiro认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userCode, userPwd);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            reJson.setMessage("账户不存在");
        } catch (DisabledAccountException e) {
            log.info("ss", e);
            reJson.setMessage("账户存在问题");
        } catch (AuthenticationException e) {
            log.info("ss", e);
            reJson.setMessage("密码错误");
        } catch (Exception e) {
            reJson.setMessage("登陆异常");
        }

        reJson.setData("/success");
        return reJson;
    }
}
