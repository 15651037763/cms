package com.pf.org.cms.service.impl;

import com.pf.org.cms.entity.Demo;
import com.pf.org.cms.mapper.DemoMapper;
import com.pf.org.cms.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "demoServie")
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> getDemos() {
        return demoMapper.getDemos();
    }
}
