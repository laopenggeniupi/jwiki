package com.pl.jwiki.controller;


import com.pl.jwiki.domain.Demo;
import com.pl.jwiki.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController  //RestController返回字符串和json  Controller返回的是jsp,html页面  RestController=Controller+ResponseBody
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping("/demo/list")
    public List<Demo> list() {
        return demoService.list();
    }

}
