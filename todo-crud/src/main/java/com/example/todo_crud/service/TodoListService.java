package com.example.todo_crud.service;

import com.example.todo_crud.model.TodoList;
import com.example.todo_crud.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    private final ListRepository listRepository;

    public TodoListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    public Long join(TodoList todoList) {
        TodoList savedTodo = listRepository.save(todoList);
        return savedTodo.getId();
    }

    public List<TodoList> findTodoList() {
        return listRepository.findAll();
    }

    public Optional<TodoList> findOne(Long listId) {
        return listRepository.findById(listId);
    }
}
