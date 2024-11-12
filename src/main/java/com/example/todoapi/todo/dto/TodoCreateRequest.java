package com.example.todoapi.todo.dto;

import com.example.todoapi.todo.Todo;
import lombok.Getter;

@Getter
public class TodoCreateRequest {
    private String content;
    private Long memberId;
}
