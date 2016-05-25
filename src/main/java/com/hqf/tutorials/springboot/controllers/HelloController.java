package com.hqf.tutorials.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huoquanfu on 2016/5/25.
 */

@RestController
public class HelloController {
    /**
     * 访问 http://127.0.0.1:8080/
     */
    @RequestMapping("/")
    public String hello() {
        return "Hello world!";
    }

}
