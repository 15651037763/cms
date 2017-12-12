package com.pf.org.cms.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
