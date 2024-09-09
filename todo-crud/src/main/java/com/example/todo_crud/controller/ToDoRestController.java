package com.example.todo_crud.controller;

import com.example.todo_crud.domain.UserList;
import com.example.todo_crud.dto.LoginRequestDTO;
import com.example.todo_crud.dto.LoginResponseDTO;
import com.example.todo_crud.service.UserListService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sign")
public class ToDoRestController {

    private final UserListService userListService;

    public ToDoRestController(UserListService userListService) {
        this.userListService = userListService;
    }

    @PostMapping
    public Optional<LoginResponseDTO> login(@RequestBody LoginRequestDTO req) {

        System.out.println(userListService.login(req.getUserName(), req.getPassword()));
        return userListService.login(req.getUserName(), req.getPassword());
    }
}
