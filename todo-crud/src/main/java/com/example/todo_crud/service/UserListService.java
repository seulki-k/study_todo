package com.example.todo_crud.service;

import com.example.todo_crud.domain.UserList;
import com.example.todo_crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserListService {

    private final UserRepository userRepository;

    public UserListService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserList> login(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName,password);
    }
}
