package com.example.demo.testexample;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void add(){
        Calculator calculator = new Calculator();
        int result = calculator.add(1,2);

        assertNotNull(result);
        assertEquals(3, result, "加法有問題");
        assertTrue(result > 1);
    }

    @Test
    public void divide(){
        Calculator calculator = new Calculator();

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }
}