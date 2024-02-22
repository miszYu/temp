package com.example.demo.model.bo.impl;

import com.example.demo.model.bo.Printer;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;


public class HpPrinter implements Printer {

    private int count;

    //使用冒號設定預設值
    @Value("${printer.name:unknow}")
    private String name;

    //一種Bean初始化的方法，任意method加上@PostConstruct
    @PostConstruct
    public void initialize(){

        this.count = 5;
    }
    @Override
    public void print(String message) {
        this.count--;
        System.out.println("名稱: " + this.name);
        System.out.println("HP印表機: " + message);
        System.out.println("剩餘使用次數: " + this.count);
    }
}
