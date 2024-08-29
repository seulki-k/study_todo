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


    //등록하는 페이지로 이동
    @GetMapping("/todoList/new")
    public String showAddTodoPage() {
        return "todobook/todoListAdd";
    }


    @PostMapping("/todoList/new")
    public String create(
            // 제목 입력 name = title
            //  <input type="text" id="name" name="title" placeholder="할 일을 입력하세요."/>
            // 여기서 입력한 값이 value에 해당한다.
            @RequestParam("title") String title,
            //  <button type="submit" name="action" value="submit">등록</button>
            //  <button type="submit" name="action" value="cancel">취소</button>
            // value 값은 두 가지로 submit - 등록 ,cancel - 취소
            @RequestParam("action") String action) {
            //값만 저장하고 출력하는 페이지는 아니므로 Model 파라미터는 제외
        if ("submit".equals(action)) {
            // 데이터 저장
            TodoList todoList = new TodoList();
            todoList.setTitle(title);
            todoListService.join(todoList);
        }
        return "redirect:/todoList";
    }

    @GetMapping("/todoList/list")
    public String list(Model model) {
        List<TodoList> tdLists = todoListService.findTodoList();
        model.addAttribute("tdLists", tdLists); // Consistent with the template
        return "todobook/todoList-detail";
    }

    @PostMapping("/todoList/change")
    public String changeTodo(
            @RequestParam("id") Long id,
            @RequestParam("action") String action) {
        // Completed 값반 전환
        todoListService.updateCompleted(id);

        return "redirect:/todoList/list";

    }

}
