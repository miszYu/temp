package com.example.demo.testexample;

import org.junit.jupiter.api.*;

public class TestAnnotationExample {
    //在所有@Test開始前會執行一次，需使用靜態方法
    @BeforeAll
    public static void beforeAll(){
        System.out.println("執行 @BeforeAll");
    }

    //在所有@Test結束後會執行一次，需使用靜態方法
    @AfterAll
    public static void afterAll(){
        System.out.println("執行 @AfterAll");
    }

    //在每次@Test開始前都會執行一次
    @BeforeEach
    public void beforeEach(){
        System.out.println("執行 @BeforeEach");
    }

    //在每次@Test結束後都會執行一次
    @AfterEach
    public void afterEach(){
        System.out.println("執行 @AfterEach");
    }

    @Test
    public void test1(){
        System.out.println("執行 test1");
    }

    //@DisplayName自定義顯示名稱
    @DisplayName("test2測試")
    @Test
    public void test2(){
        System.out.println("執行 test2");
    }

    //@Disabled忽略該@Test不執行
    @Disabled
    @Test
    public void test3(){
        System.out.println("執行 test3");
    }
}
