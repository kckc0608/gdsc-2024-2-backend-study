package com.example.todoapi.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig2 {

    @Bean
    MyBean myBean() {
        return new MyBean();
    }

    @Bean
    MySubBean mySubBean() {
        return new MySubBean();
    }
}
