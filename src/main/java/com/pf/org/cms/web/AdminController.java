package com.pf.org.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: pf
 * @Date: 2017/12/19 11:52
 * @Description:
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @ResponseBody
    @RequestMapping(value = "/testAuthorization")
    public String testAuthorization() {
        return "你拥有admin访问权限";
    }
}
