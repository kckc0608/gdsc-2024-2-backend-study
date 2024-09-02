package com.example.todoapi.todo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todoapi.common.exception.BadRequestException;
import com.example.todoapi.common.message.ExceptionMessage;
import com.example.todoapi.user.User;
import com.example.todoapi.user.UserRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long createTodo(String content, Long userId) throws Exception {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new BadRequestException(ExceptionMessage.USER_NOT_EXISTS);
        }

        Todo todo = new Todo(content, user);
        todoRepository.save(todo);
        return todo.getId();
    }

    @Transactional(readOnly = true)
    public List<Todo> readTodos(Long userId) throws Exception {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new BadRequestException(ExceptionMessage.USER_NOT_EXISTS);
        }

        return todoRepository.findAllByUser(user);
    }

    @Transactional
    public void updateContent(Long todoId, String newContent) {
        Todo todo = todoRepository.findById(todoId);
        todo.updateContent(newContent);
    }

    @Transactional
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
