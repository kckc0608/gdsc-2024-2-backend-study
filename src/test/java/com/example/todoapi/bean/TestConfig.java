package com.example.todoapi.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    MyBean myBean() {
        return new MyBean(mySubBean());
    }

    @Bean
    MySubBean mySubBean() {
        return new MySubBean();
    }
}
