package com.example.todoapi.todo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TodoReposotoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveTest() {
        Todo todo = Todo.builder()
                .content("test")
                .build();
        todoRepository.save(todo);
    }

    @AfterAll
    static void test() {
        System.out.println("test finish");
        while(true) {

        }
    }

}
