package com.example.demo.controller;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
@RequestMapping(path ="/path", method = {RequestMethod.GET, RequestMethod.POST})
public class PathController {
    @Autowired
    HttpServletRequest request;

    @Resource
    HttpServletResponse response;

    @RequestMapping("/{my_path}")
    public String my_path(@PathVariable String my_path){

        JsonObject json = new JsonObject();
        json.addProperty("my_path", my_path);

        return json.toString();
    }
}
