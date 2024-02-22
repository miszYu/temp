package com.example.demo;

import com.example.demo.model.bo.Printer;
import com.example.demo.model.bo.impl.HpPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    //@Bean後不特別指定name，則預設會以方法名稱當作bean name
    @Bean("hpPrinter")
    public Printer getHpPrinte() {
        return new HpPrinter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
