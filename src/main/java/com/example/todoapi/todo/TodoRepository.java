package com.example.todoapi.todo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.todoapi.user.User;

import java.util.List;

@Repository
public class TodoRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Todo todo) {
        em.persist(todo);
    }

    public Todo findById(Long id) {
        return em.find(Todo.class, id);
    }

    public List<Todo> findAll() {
        return em.createQuery("select t from Todo as t", Todo.class)
                .getResultList();
    }

    public List<Todo> findAllByUser(User user) {
        return em.createQuery("select t from Todo as t where t.user = :user", Todo.class)
                .setParameter("user", user)
                .getResultList();
    }


}
