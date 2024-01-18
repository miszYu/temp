package com.example.demo.model.clazz;

import org.springframework.stereotype.Component;

public class Student {

    String name;

    Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
