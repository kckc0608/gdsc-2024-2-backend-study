package com.example.todoapi.todo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.todoapi.user.User;
import com.example.todoapi.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void testTodoCreate() throws Exception {
        // given
        given(userRepository.findById(anyLong())).willReturn(new User());

        // when
        todoService.createTodo("content", 1L);

        // then
        verify(todoRepository, times(1)).save(any(Todo.class));
    }

    @Test
    void testTodoCreate_fail_WhenUserNotExist() throws Exception {
        // given
        given(userRepository.findById(anyLong())).willReturn(null);

        // when & then
        Assertions.assertThatThrownBy(() -> todoService.createTodo("content", 1L))
                .isInstanceOf(Exception.class)
                .hasMessage("존재하지 않는 유저 ID 입니다.");
    }

}
