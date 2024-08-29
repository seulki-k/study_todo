package com.example.todo_crud;

import com.example.todo_crud.controller.ToDoController;
import com.example.todo_crud.repository.ListRepository;
import com.example.todo_crud.service.TodoListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final ListRepository listRepository;

    public SpringConfig(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Bean
    public TodoListService todoListService() {
        return new TodoListService(listRepository);
    }


}
