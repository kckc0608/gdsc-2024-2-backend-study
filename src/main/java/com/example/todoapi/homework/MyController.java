package com.example.todoapi.homework;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyController {

    private final MyService myService;

    void test() {
        System.out.println("controller");
        myService.test();
    }
}
