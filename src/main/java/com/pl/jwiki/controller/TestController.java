package com.pl.jwiki.controller;


import com.pl.jwiki.domain.Test;
import com.pl.jwiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController  //RestController返回字符串和json  Controller返回的是jsp,html页面  RestController=Controller+ResponseBody
public class TestController {

    @Resource
    private TestService testService;

    @Value("${test.hello}")
    private String testHello;


    //http://127.0.0.1:8880/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!" + testHello;
    }

    @PostMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World! POST," + name;
    }

    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }

}
