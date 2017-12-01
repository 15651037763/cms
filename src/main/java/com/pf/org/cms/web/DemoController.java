package com.pf.org.cms.web;

        import com.pf.org.cms.entity.Demo;
        import com.pf.org.cms.service.DemoService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.List;
        import java.util.Map;

@Controller
@RequestMapping(value =  "/demo")
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoService demoService;

    @Value("${spring.profiles.active}")
    private String profileActive;

    @RequestMapping(value = "/getAll")
    public String testDemo(Map<String,Object> map) {
        List<Demo> demos = demoService.getDemos();
        map.put("data", demos);
        System.out.println(demos.toString());
        System.out.println(profileActive);
        log.debug("debug---log-------------"+demos.toString());
        log.info("info---log-------------"+demos.toString());
        log.warn("warn---log-------------"+demos.toString());
        log.error("error---log-------------"+demos.toString());
        return ("/testDemo");
    }
}
