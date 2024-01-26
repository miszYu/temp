package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping(path = "/test1", method = {RequestMethod.GET, RequestMethod.POST})
    public void test1(){
        throw new RuntimeException("/test1 error");
    }

    @RequestMapping(path = "/test2", method = {RequestMethod.GET, RequestMethod.POST})
    public void test2(){
        throw new IllegalArgumentException("/test2 error");
    }
}