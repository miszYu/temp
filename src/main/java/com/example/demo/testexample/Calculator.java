package com.example.demo.testexample;

public class Calculator {

    public static void main(String[]args){
        Calculator calculator = new Calculator();
        int result = calculator.add(1,2);
        System.out.println("result = " + result);
    }

    public int add(int x, int y){
        return x + y;
    }

    public double divide(int x, int y){
        return x/y;
    }
}
