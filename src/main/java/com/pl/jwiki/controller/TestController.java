package com.pl.jwiki.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //http://127.0.0.1:8880/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
