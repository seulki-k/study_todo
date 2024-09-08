package com.example.todo_crud.controller;

import com.example.todo_crud.dto.LoginRequestDTO;
import com.example.todo_crud.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String joinProcess(LoginRequestDTO joinDTO) {
        try {
            joinService.joinProcess(joinDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
