package com.example.demo;

import com.example.demo.model.Printer;
import com.example.demo.model.impl.HpPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    //@Bean後不特別指定name，則預設會以方法名稱當作bean name
    @Bean("hpPrinter")
    public Printer getHpPrinte() {

        return new HpPrinter();
    }
}
