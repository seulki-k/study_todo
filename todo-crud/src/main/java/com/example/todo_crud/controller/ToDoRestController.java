package com.example.todo_crud.controller;

import com.example.todo_crud.domain.UserList;
import com.example.todo_crud.dto.LoginRequestDTO;
import com.example.todo_crud.service.UserListService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sign")
public class ToDoRestController {

    private final UserListService userListService;

    public ToDoRestController(UserListService userListService) {
        this.userListService = userListService;
    }

    @PostMapping
    // @RequestBody - HTTP 요청 본문을 메소드 파라미터로 전달된 Java 객체로 변환
    public Optional<UserList> login(@RequestBody LoginRequestDTO req) {

        // 사용자 ID와 비밀번호를 사용하여 로그인 시도.
        // userListService는 로그인 처리 서비스이며, 결과는 Optional<UserList>로 반환됨.
        // Optional 은 Null은 안정성 있게 제공하기 위해 사용. 값이 있을 수도, 없을 수도 있다.
        //  return userRepository.findByUserIdAndPassword(userId, password); - 받아 온 값과 DB가 일치하면 저장
        Optional<UserList> user = userListService.login(req.getUserId(), req.getPassword());
        System.out.println("user = " + user);
        return user;
    }
}
