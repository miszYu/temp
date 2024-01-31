package com.example.demo.controller;

import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//restFUL API，header範例。使用@RequestHeader從header取值。

@RestController
@RequestMapping(path="/header", method = {RequestMethod.GET, RequestMethod.POST})
public class HeaderController {

    @RequestMapping("/my_header")
    public String my_header(@RequestHeader(name="Content-Type", defaultValue = "application/json") String contentType, @RequestHeader String info){

        System.out.println("Content-Type: " + contentType);
        System.out.println("info: " + info);

        JsonObject json = new JsonObject();
        json.addProperty("Content-Type", contentType);
        json.addProperty("info", info);

        return json.toString();
    }
}
