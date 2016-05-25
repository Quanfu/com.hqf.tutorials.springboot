package com.hqf.tutorials.springboot.controllers;


import com.hqf.tutorials.springboot.models.Demo;
import com.hqf.tutorials.springboot.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by huoquanfu on 2016/5/25.
 */
@RestController
@RequestMapping("/demo2")
public class Demo2Controller {
    @Resource
    private DemoService demoService;

    /**
     * 测试保存数据方法.
     * http://127.0.0.1:8080//demo2/save
     * @return
     */
    @RequestMapping("/save")
    public String save() {
        Demo d = new Demo();
        d.setName("Angel");
        demoService.save(d);//保存数据.
        return "ok.Demo2Controller.save";
    }

}
