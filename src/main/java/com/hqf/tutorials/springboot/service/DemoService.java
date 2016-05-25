package com.hqf.tutorials.springboot.service;

/**
 * Created by huoquanfu on 2016/5/25.
 * 提供Demo服务类.
 *
 * @author Administrator
 */

import com.hqf.tutorials.springboot.dao.DemoRepository;
import com.hqf.tutorials.springboot.models.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class DemoService {

    @Resource
    private DemoRepository demoRepository;

    @Transactional
    public void save(Demo demo) {
        demoRepository.save(demo);
    }
}
