package com.example.demo.model.dto;

import javax.validation.constraints.NotNull;



public class Product {
    @NotNull
    Integer no;

    String name;

    String desctxt;

    public Product(){};

    public Product(Integer no, String name, String desctxt){
        this.no = no;
        this.name = name;
        this.desctxt = desctxt;
    };


    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesctxt() {
        return desctxt;
    }

    public void setDesctxt(String desctxt) {
        this.desctxt = desctxt;
    }
}
