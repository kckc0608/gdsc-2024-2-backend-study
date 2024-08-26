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
import com.example.todoapi.user.UserRepository;

import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void todoCreateTest() {
        // given
        Todo todo = new Todo("content", false, null);

        // when
        todoRepository.save(todo);

        // then
        assertThat(todo.getId()).isNotNull();
    }

    @Test
    @Transactional
    void todoFindOneTest() {
        // given
        Todo todo = new Todo("content", false, null);
        todoRepository.save(todo);

        // when
        Todo findTodo = todoRepository.findById(todo.getId());

        // then
        assertThat(todo).isNotNull();
        System.out.println(todo.getId());
        System.out.println(todo.getContent());
    }

    @Test
    @Transactional
    void todoFindAllTest() {
        // given
        todoRepository.save(new Todo("content1", false, null));
        todoRepository.save(new Todo("content2", false, null));
        todoRepository.save(new Todo("content3", false, null));

        // when
        List<Todo> todos = todoRepository.findAll();

        // then
        assertThat(todos).hasSize(3);
    }

    @Test
    @Transactional
    void todoFindAllByUserTest() {
        // given
        User user1 = new User(); User user2 = new User();
        userRepository.save(user1); userRepository.save(user2);

        todoRepository.save(new Todo("content1", false, user1));
        todoRepository.save(new Todo("content2", false, user1));
        todoRepository.save(new Todo("content3", false, user2));

        // when
        List<Todo> todosByUser1 = todoRepository.findAllByUser(user1);
        List<Todo> todosByUser2 = todoRepository.findAllByUser(user2);

        // then
        assertThat(todosByUser1).hasSize(2);
        assertThat(todosByUser2).hasSize(1);
    }

    @AfterAll
    static void test() {
        System.out.println("test finish");
        while(true) {

        }
    }
}
