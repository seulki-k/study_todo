package com.example.todo_crud.repository;

import com.example.todo_crud.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListRepository extends JpaRepository<TodoList, Long> {

    Optional<TodoList> findByTitle(String title);


}
