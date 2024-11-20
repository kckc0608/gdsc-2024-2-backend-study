package com.example.todoapi.todo;

import com.example.todoapi.common.message.ErrorMessage;
import com.example.todoapi.member.Member;
import com.example.todoapi.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    MemberRepository memberRepository;

    @Mock
    TodoRepository todoRepository;

    @InjectMocks
    TodoService todoService;

    @Test
    public void createTodoTest() throws Exception {
        // given
        BDDMockito.given(memberRepository.findById(1L)).willReturn(new Member());

        // when
        // 테스트 할 동작 실행
        todoService.createTodo("content", 1L);

        // then
        Mockito.verify(todoRepository, Mockito.times(1)).save(Mockito.any(Todo.class));
    }

    @Test
    public void createTodoTest_When_MemberDoesNotExist() throws Exception {
        // given
        BDDMockito.given(memberRepository.findById(Mockito.anyLong())).willReturn(null);

        // when & then
        Assertions.assertThatThrownBy(() -> {
            // 테스트 할 동작 실행
            todoService.createTodo("content", 9999999L);
        })
                .hasMessageContaining(ErrorMessage.MEMBER_NOT_EXISTS)
                .isInstanceOf(Exception.class);

        Todo todo = new Todo();
    }

}
