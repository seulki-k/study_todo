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

    public void updateCompleted(Long id) {
        TodoList updateId = listRepository.getReferenceById(id);

        if (updateId.isCompleted()) {
            updateId.setCompleted(false);
        } else {
            updateId.setCompleted(true);
        }
        listRepository.save(updateId);

    }
}