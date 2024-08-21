package com.example.todoapi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class MyBean {

    @Autowired
    private MySubBean mySubBean;
}
