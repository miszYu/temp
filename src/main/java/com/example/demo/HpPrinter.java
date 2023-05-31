package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class HpPrinter implements  Printer{

    private int count;

    //一種Bean初始化的方法，任意method加上@PostConstruct
    @PostConstruct
    public void initialize(){
        this.count = 5;
    }
    @Override
    public void print(String message) {
        this.count--;
        System.out.println("HP印表機: " + message);
        System.out.println("剩餘使用次數: " + this.count);
    }
}
