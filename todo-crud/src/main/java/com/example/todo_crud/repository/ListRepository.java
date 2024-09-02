package com.example.todo_crud.repository;

import com.example.todo_crud.domain.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<TodoList, Long> {

}
