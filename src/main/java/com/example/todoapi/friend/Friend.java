package com.example.todoapi.friend;

import com.example.todoapi.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member1")
    private Member member1;

    @ManyToOne
    @JoinColumn(name = "member2")
    private Member member2;

    public Friend(Member member1, Member member2) {
        this.member1 = member1;
        this.member2 = member2;
    }
}
