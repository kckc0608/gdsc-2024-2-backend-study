package com.example.todoapi.todo.dto;

import com.example.todoapi.common.message.ErrorMessage;
import com.example.todoapi.todo.Todo;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class TodoCreateRequest {

    @NotNull
    @Length(max = 200, message = "content의 길이는 200자를 넘을 수 없습니다.")
    private String content;

    @NotNull(message = ErrorMessage.MEMBER_ID_MUST_BE_NOT_NULL)
    private Long memberId;
}
