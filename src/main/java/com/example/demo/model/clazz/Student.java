package com.example.demo.model.clazz;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Student {

    @NotNull
    Integer id;

    @NotBlank
    String name;

    public Student(){};
    public Student(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println("id = " + id);
        System.out.println("name = " + name );
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }

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
