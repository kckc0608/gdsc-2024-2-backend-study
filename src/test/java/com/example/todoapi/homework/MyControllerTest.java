package com.example.todoapi.homework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyControllerTest {

    @Autowired
    private MyController myController;

    @Test
    void myControllerTest() {
        myController.test();
    }

}
