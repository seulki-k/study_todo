package com.example.todo_crud.domain;

import jakarta.persistence.*;

@Entity
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

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserList(Long accountNo, String userId, String password) {
        this.accountNo = accountNo;
        this.userId = userId;
        this.password = password;
    }
}
