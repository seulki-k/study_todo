package com.example.todo_crud.repository;

import com.example.todo_crud.domain.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserList, Long> {
    Optional<UserList> findByUserIdAndPassword(String userId, String password);
}
