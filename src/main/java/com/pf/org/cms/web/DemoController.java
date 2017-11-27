package com.pf.org.cms.web;

import com.pf.org.cms.entity.Demo;
import com.pf.org.cms.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value =  "/demo")
public class DemoController {
    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/getAll")
    public String testDemo(Map<String,Object> map) {
        List<Demo> demos = demoService.getDemos();
        map.put("data", demos);
        System.out.println(demos.toString());
        return ("/testDemo");
    }
}
