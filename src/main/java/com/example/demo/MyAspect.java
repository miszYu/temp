package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.example.demo.model.bo.impl.HpPrinter.*(..))")
    public void before(){
        System.out.println("I am @Before >> before");
    }

    @After("execution(* com.example.demo.model.bo.impl.HpPrinter.*(..))")
    public void after(){
        System.out.println("I am @After >> after");
    }

    @Around("execution(* com.example.demo.model.bo.impl.CanonPrinter.*(..))")
    public Object around(ProceedingJoinPoint pip) throws Throwable{
        System.out.println("I am @Around >> before");
        Object obj = pip.proceed();
        System.out.println("I am @Around >> after");

        return obj;
    }
}
