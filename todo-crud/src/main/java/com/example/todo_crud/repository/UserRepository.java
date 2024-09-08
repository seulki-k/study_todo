package com.example.todo_crud.repository;

import com.example.todo_crud.domain.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserList, Long> {

    Optional<UserList> findByUserNameAndPassword(String userName, String password);

    boolean existsByUserName(String userName);

    UserList findByUserName(String userName);
}
