package com.pf.org.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: pf
 * @Date: 2017/12/19 15:16
 * @Description:
 */
@Controller
@RequestMapping(value = "/errorPage")
public class ErrorPageController {

    @RequestMapping(value = "/403")
    public String http403() {
        return "/errorPage/403";
    }

    @RequestMapping(value = "/404")
    public String http404() {
        return "/errorPage/404";
    }
}
