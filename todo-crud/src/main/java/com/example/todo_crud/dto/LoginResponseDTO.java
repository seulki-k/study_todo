package com.example.todo_crud.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private String token;

    public LoginResponseDTO(String token) {

        this.token = token;
    }

    // Getter/Setter 생략
}
