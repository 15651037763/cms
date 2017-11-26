package com.pf.org.cms.web;

import com.pf.org.cms.entity.Demo;
import com.pf.org.cms.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  "/demo")
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/getAll")
    public Object testDemo() {
        List<Demo> ls = demoService.getDemos();
        System.out.println(ls.toString());
        return ls;
    }
}
