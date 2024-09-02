package com.example.todo_crud.controller;

import com.example.todo_crud.domain.UserList;
import com.example.todo_crud.dto.LoginRequestDTO;
import com.example.todo_crud.service.UserListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class ToDoRestController {

    private final UserListService userListService;

    public ToDoRestController(UserListService userListService) {
        this.userListService = userListService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO req) {
        Optional<UserList> user = userListService.login(req.getUserId(), req.getPassword());

        if (user.isPresent()) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Login failed: Invalid ID or Password");
        }
    }
}
