package com.example.todo_crud.controller;

import com.example.todo_crud.model.TodoList;
import com.example.todo_crud.service.TodoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restful")
public class ToDoRestController {

    private final TodoListService todoListService;

    public ToDoRestController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    // GET - 조회
    @GetMapping
    public List<TodoList> getAllTodos() {
        List<TodoList> tdLists = todoListService.findTodoList();
        return tdLists;
    }

    // POST - 추가
    @PostMapping
    public List<TodoList> addTodo(@RequestParam("title") String title) {
        TodoList todoList = new TodoList();
        todoList.setTitle(title);
        todoListService.join(todoList);

        return todoListService.findTodoList();
    }

    // DELETE - 삭제
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
    }
}
