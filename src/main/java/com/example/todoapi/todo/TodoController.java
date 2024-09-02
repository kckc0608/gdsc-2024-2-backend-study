package com.example.todoapi.todo;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.common.message.ExceptionMessage;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ApiResponse(responseCode = "404", description = "요청에 들어온 user id 가 존재하지 않음")
    public ResponseEntity<Void> createTodo(@RequestBody @Valid TodoCreateRequest request) throws Exception {
        Long todoId = todoService.createTodo(request.getContent(), request.getUserId());
        return ResponseEntity.created(URI.create("/todo/" + todoId)).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Todo>> getTodoList(@RequestBody Long userId) throws Exception {
        List<Todo> todos = todoService.readTodos(userId);
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<Void> updateTodoContent(@PathVariable Long todoId, @RequestBody String newContent) {
        todoService.updateContent(todoId, newContent);
        return ResponseEntity.ok().build();
    }
}

