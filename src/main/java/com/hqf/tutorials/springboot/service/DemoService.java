package com.hqf.tutorials.springboot.service;

/**
 * Created by huoquanfu on 2016/5/25.
 * 提供Demo服务类.
 *
 * @author Administrator
 */

import com.hqf.tutorials.springboot.dao.DemoDao;
import com.hqf.tutorials.springboot.dao.DemoRepository;
import com.hqf.tutorials.springboot.models.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class DemoService {

    @Resource
    private DemoRepository demoRepository;

    @Resource
    private DemoDao demoDao;

    @Transactional
    public void save(Demo demo) {
        demoRepository.save(demo);
    }

    public Demo getById(long id){
        //demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.

        return demoDao.getById(id);
    }
}
