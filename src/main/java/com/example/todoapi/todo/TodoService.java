package com.example.todoapi.todo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void createTodo(String content, Long userId) throws Exception {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new Exception("존재하지 않는 유저 ID 입니다.");
        }

        Todo todo = new Todo(content, user);
        todoRepository.save(todo);
    }

    @Transactional(readOnly = true)
    public List<Todo> readTodos(Long userId) throws Exception {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new Exception("존재하지 않는 유저 ID 입니다.");
        }

        return todoRepository.findAllByUser(user);
    }

    @Transactional
    public void updateContent(Long todoId, String newContent) {
        Todo todo = todoRepository.findById(todoId);
        todo.updateContent(newContent);
    }

    @Transactional
    public void deleteContent(Long todoId) {
        todoRepository.deleteById(todoId);
    }

}
