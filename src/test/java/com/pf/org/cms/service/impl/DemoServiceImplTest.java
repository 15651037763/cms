package com.pf.org.cms.service.impl;

import com.pf.org.cms.entity.Demo;
import com.pf.org.cms.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: pf
 * @Date: 2018/2/3 10:53
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class DemoServiceImplTest {
    @Autowired
    private DemoService demoService;

    @Test
    public void batchInsert() throws Exception {
        long t = System.currentTimeMillis();
        List<Demo> ls = new ArrayList<>();
        for (int i = 0; i < 12104; i++) {
            Demo demo = new Demo();
            demo.setName("test" + String.valueOf(i));
            demo.setRemark("testRemark");
            ls.add(demo);
        }
        demoService.batchAddDemo(ls);
        System.out.println("总耗时(ms)：" + String.valueOf(System.currentTimeMillis() - t));
    }
}
