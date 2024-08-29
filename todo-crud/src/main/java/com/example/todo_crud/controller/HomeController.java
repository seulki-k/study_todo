package com.example.todo_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/todoList")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String restfulHome() {
        return "/restful/restful";
    }
}
