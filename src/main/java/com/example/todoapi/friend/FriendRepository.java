package com.example.todoapi.friend;

import com.example.todoapi.member.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Friend friend) {
        em.persist(friend);
    }

    public void delete(Friend friend) {
        em.remove(friend);
    }

    public List<Friend> findByMember(Member member) {
        return em.createQuery(
                "select f from Friend f where f.member1 = :check_member or f.member2 = :check_member", Friend.class)
                .setParameter("check_member", member)
                .getResultList();
    }
}
