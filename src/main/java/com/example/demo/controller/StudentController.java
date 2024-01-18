package com.example.demo.controller;

import com.example.demo.model.clazz.Store;
import com.example.demo.model.clazz.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/store")
    public Store product(){
        //http://localhost:8080/test/store
        Store store = new Store();
        List<String> product = new ArrayList<>();
        product.add("蘋果");
        product.add("橘子");

        store.setProductList(product);

        return store;
    }
    @RequestMapping("/user")
    public Student user(){
        //http://localhost:8080/test/user
        Student student = new Student();
        student.setName("Judy");

        return student;
    }
}
