package com.example.todoapi.todo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.todoapi.user.User;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void todoCreateTest() {
        // given
        Todo todo = new Todo("content", false, null);

        // when
        todoRepository.save(todo);

        // then
        assertThat(todo.getId()).isNotNull();
    }

    @AfterAll
    static void test() {
        System.out.println("test finish");
        while(true) {

        }
    }
}
