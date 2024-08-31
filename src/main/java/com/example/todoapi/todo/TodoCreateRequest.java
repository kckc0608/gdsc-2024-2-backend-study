package com.example.todoapi.todo;

import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;

@Getter
public class TodoCreateRequest {

    @Length(max = 200, message = "할 일 내용은 200자를 넘을 수 없습니다.")
    private String content;

    @NotNull(message = "유저 ID는 필수입니다.")
    private Long userId;

}
