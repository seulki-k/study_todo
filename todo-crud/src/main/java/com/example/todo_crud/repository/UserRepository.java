package com.example.todo_crud.repository;

import com.example.todo_crud.domain.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserList, Long> {
    Optional<UserList> findByUserIdAndPassword(String userId, String password);
}
