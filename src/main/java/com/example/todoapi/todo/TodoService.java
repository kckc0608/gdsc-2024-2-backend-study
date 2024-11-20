package com.example.todoapi.todo;

import com.example.todoapi.common.exception.BadRequestException;
import com.example.todoapi.common.message.ErrorMessage;
import com.example.todoapi.member.Member;
import com.example.todoapi.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long createTodo(String content, Long memberId) throws Exception {
        Member member = memberRepository.findById(memberId);

        if (member == null) {
            throw new BadRequestException("존재하지 않는 유저입니다.");
        }

        Todo todo = new Todo(content, member);
        todoRepository.save(todo);
        return todo.getId();
    }

    @Transactional(readOnly = true)
    public List<Todo> getTodoList(Long memberId)  throws  Exception {
        Member member = memberRepository.findById(memberId);
        if (member == null) {
            throw new BadRequestException(ErrorMessage.MEMBER_NOT_EXISTS);
        }

        return todoRepository.findAllByMember(member);
    }

    @Transactional
    public void updateTodo(Long todoId, Long memberId, String updateContent) throws Exception {
        Todo todo = todoRepository.findById(todoId);
        Member member = memberRepository.findById(memberId);

        if (todo == null) {
            throw new Exception("존재하지 않는 할 일 입니다.");
        }

        if (member == null) {
            throw new Exception(ErrorMessage.MEMBER_NOT_EXISTS);
        }

        if (todo.getMember() != member) {
            throw new Exception("할 일을 생성한 유저만 수정할 수 있습니다.");
        }

        todo.updateContent(updateContent);
    }

    @Transactional
    public void deleteTodo(Long todoId) throws Exception {
        todoRepository.deleteById(todoId);
    }


}
