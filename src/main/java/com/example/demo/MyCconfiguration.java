package com.example.demo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCconfiguration {

    @Bean("hpPrinter")
    public Printer hpPrinte() {
        return new HpPrinter();
    }
}
