package com.example.todo_crud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class UserList {

    @Id // PK 설정
    // 기본 키 값 자동 증가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNo;

    @Column(nullable = false)
    private String userId;

    private String password;

    public UserList() {
    }

    public UserList(Long accountNo, String userId, String password) {
        this.accountNo = accountNo;
        this.userId = userId;
        this.password = password;
    }
}
