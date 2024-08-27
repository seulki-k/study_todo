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
    public String create(
            // 제목 입력 name = title
            @RequestParam("title") String title,
            // submit - 등록 ,cancel - 취소
            @RequestParam("action") String action,
            Model model) {

        if ("submit".equals(action)) {
            // 데이터 저장
            TodoList todoList = new TodoList();
            todoList.setTitle(title);
            todoListService.join(todoList);
            return "redirect:/"; // 리스트 페이지로 리디렉션
        } else if ("cancel".equals(action)) {
            // 취소 처리: /페이지로  리디렉션
            return "redirect:/";
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
    public String 탈주(@RequestParam("action") String action,
                     Model model) {

        return "redirect:/";
    }

    @PostMapping("/todoList/change")
    public String changeTodo(
            @RequestParam("id") Long id,
            @RequestParam("action") String action,
            Model model) {

        todoListService.updateCompleted(id);

            return "redirect:/todoList/list";

    }

}
