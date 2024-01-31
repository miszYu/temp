package com.example.demo.controller;

import com.example.demo.model.clazz.Student;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//restFUL API，post範例。使用@RequestBody取得body內的值

@RestController
@RequestMapping("/post_method")
public class PostMethodController {

    @RequestMapping(path="/my_post", method = {RequestMethod.GET, RequestMethod.POST})
    public String my_post(@RequestBody Student student){
        Integer id = student.getId();
        String name = student.getName();

        System.out.println("student id: " + id);
        System.out.println("student name: " + name);

        JsonObject json = new JsonObject();
        json.addProperty("id", id);
        json.addProperty("name", name);

        return json.toString();
    }
}
