package com.hqf.tutorials.springboot.controllers;

import com.hqf.tutorials.springboot.models.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huoquanfu on 2016/5/25.
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("/demos")
    List<Demo> getDemos() {
        List<Demo> demos = new ArrayList<>();
        Demo demo = new Demo();
        demo.setId(1);
        demo.setName("Demo for spring boot");
        demos.add(demo);
        return demos;
    }

}
