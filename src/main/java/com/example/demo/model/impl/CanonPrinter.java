package com.example.demo.model.impl;

import com.example.demo.model.Printer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer, InitializingBean {

    private int count;

    //一種Bean初始化的方法，implements InitializingBean後Override afterPropertiesSet方法
    @Override
    public void afterPropertiesSet() throws Exception{
        this.count = 3;
    }
    @Override
    public void print(String message) {
        this.count--;
        System.out.println("Canon印表機: " + message);
        System.out.println("剩餘使用次數: " + this.count);
    }
}
