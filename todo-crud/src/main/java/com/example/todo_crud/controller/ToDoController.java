package com.example.todo_crud.controller;

import com.example.todo_crud.model.TodoList;
import com.example.todo_crud.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {


    private TodoListService todoListService;

    @Autowired
    public ToDoController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping("/todoList/new")
    public String showAddTodoPage() {
        return "todobook/todoListAdd";
    }

    @PostMapping("/todoList/new")
    public String create(@RequestParam("title") String title,
                         @RequestParam("action") String action,
                         Model model) {

        if ("submit".equals(action)) {
            // 데이터 저장
            TodoList todoList = new TodoList();
            todoList.setTitle(title);
            todoListService.join(todoList);
            return "redirect:/"; // 리스트 페이지로 리디렉션
        } else if ("cancel".equals(action)) {
            // 취소 처리: 다른 페이지로 리디렉션
            return "redirect:/"; // 예를 들어 홈 페이지로 리디렉션
        }
    return "redirect:/";
    }

    @GetMapping("/todoList/list")
    public String list(Model model) {
        List<TodoList> tdLists = todoListService.findTodoList();
        model.addAttribute("tdLists", tdLists); // Consistent with the template
        return "todobook/todoList-detail";
    }
    @PostMapping("/todoList/list")
    public String 탈주(){
        return "redirect:/";
    }
}
