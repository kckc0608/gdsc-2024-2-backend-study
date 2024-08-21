package com.example.todoapi.homework;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyService {

    private final MyRepository myRepository;

    void test() {
        System.out.println("service");
        myRepository.test();
    }
}
