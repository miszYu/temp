package com.example.demo.controller;

import com.example.demo.model.dto.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//練習使用spring-jpa
@RestController
@RequestMapping("/jpa")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add")
    public String create(@RequestBody @Valid Teacher teacher){
        Teacher reasult = teacherService.insert(teacher);

        return "新增Teacher成功，id = " + reasult.getId() + ", name = " + reasult.getName();
    }
}
