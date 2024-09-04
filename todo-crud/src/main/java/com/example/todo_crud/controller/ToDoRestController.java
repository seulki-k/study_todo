package com.example.todo_crud.controller;

import com.example.todo_crud.domain.UserList;
import com.example.todo_crud.dto.LoginRequestDTO;
import com.example.todo_crud.service.UserListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class ToDoRestController {

    private final UserListService userListService;

    public ToDoRestController(UserListService userListService) {
        this.userListService = userListService;
    }

    @PostMapping
    // @RequestBody - HTTP 요청 본문을 메소드 파라미터로 전달된 Java 객체로 변환
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO req) {

        // 사용자 ID와 비밀번호를 사용하여 로그인 시도.
        // userListService는 로그인 처리 서비스이며, 결과는 Optional<UserList>로 반환됨.
        // Optional 은 Null은 안정성 있게 제공하기 위해 사용. 값이 있을 수도, 없을 수도 있다.
        //  return userRepository.findByUserIdAndPassword(userId, password); - 받아 온 값과 DB가 일치하면 저장
        Optional<UserList> user = userListService.login(req.getUserId(), req.getPassword());

        // 사용자 정보가 존재하면 로그인 성공 처리.
        if (user.isPresent()) { // return value != null; 값이 null 이 아니다.
            // HTTP 200 OK 상태 코드와 함께 성공 메시지를 반환.
            return ResponseEntity.ok("Login successful!");
        } else {
            // 사용자 정보가 존재하지 않으면 로그인 실패 처리.
            // HTTP 401 Unauthorized 상태 코드와 함께 실패 메시지를 반환.
            return ResponseEntity.status(401).body("Login failed: Invalid ID or Password");
        }
    }
}
