package com.example.demo.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import org.aspectj.apache.bcel.classfile.Method;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mytest")
public class MyController {


    @RequestMapping( path = "/test01", method = {RequestMethod.GET, RequestMethod.POST})
    public String test01(@RequestParam Integer id,
                         @RequestParam(defaultValue = "Judy") String name,
                         @RequestParam(required = false) Integer age){
        //http://localhost:8080/mytest/test01

        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("age: " + age);

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("name", name);
        json.addProperty("age", age);

        return json.toString();
    }
}
