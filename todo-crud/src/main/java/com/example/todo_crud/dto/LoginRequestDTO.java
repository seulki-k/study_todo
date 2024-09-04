package com.example.todo_crud.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private String userId;
    private String password;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
