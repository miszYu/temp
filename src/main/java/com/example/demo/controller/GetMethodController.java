package com.example.demo.controller;

import com.google.gson.JsonObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//restFUL API，GET方法範例。使用@RequestParam取值。

@Tag(name = "GetMethodController")
@RestController
@RequestMapping("/get_method")
public class GetMethodController {

    @Operation(summary = "RequestMethod.GET, @RequestParam取值範例")
    @ApiResponse(responseCode = "200", description = "請求成功")
    @ApiResponse(responseCode = "404", description = "找不到文件")
    @RequestMapping( path = "/my_get", method = {RequestMethod.GET})
    public String my_get(@RequestParam Integer id,
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
