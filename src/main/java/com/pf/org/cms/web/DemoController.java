package com.pf.org.cms.web;

import com.pf.org.cms.entity.Demo;
import com.pf.org.cms.manage.RedisManager;
import com.pf.org.cms.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/demo")
@Api(description = "swagger测试接口DemoController",tags = {"DemoController"})
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @Autowired
    RedisManager redisManager;

    @Value("${spring.profiles.active}")
    private String profileActive;

    @ApiOperation(value = "获取所有信息接口" , notes = "swagger测试接口")
    @RequestMapping(value = "/getAll")
    public String testDemo(Map<String, Object> map) {
        List<Demo> demos = demoService.getDemos();
        map.put("data", demos);
        System.out.println(demos.toString());
        System.out.println(profileActive);
        log.debug("debug---log-------------" + demos.toString());
        log.info("info---log-------------" + demos.toString());
        log.warn("warn---log-------------" + demos.toString());
        log.error("error---log-------------" + demos.toString());
        return ("/testDemo");
    }

    @RequestMapping(value = "/testRedis")
    @ResponseBody
    public String testRedis(String key) {
        System.out.println("入参key为:"+key);
        String s = "查询结果为:"+redisManager.getStr(key);
        return s;
    }
}
