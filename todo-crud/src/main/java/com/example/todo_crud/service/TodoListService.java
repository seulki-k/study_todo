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

    //파라미터로 받아 온 값을 저장
    //save가 jpaRepository 메서드로 DB에 값 저장.
    public void join(TodoList todoList) {
        listRepository.save(todoList);
    }

    public List<TodoList> findTodoList() {
        return listRepository.findAll();
    }

    public void updateCompleted(Long id) {
        TodoList updateId = listRepository.getReferenceById(id);
        // id 파라미러로 받아와서 해당 id의 완료 여부 변경
        if (updateId.isCompleted()) {
            updateId.setCompleted(false);
        } else {
            updateId.setCompleted(true);
        }
        listRepository.save(updateId);
    }
    public void deleteTodoList(Long id){
        listRepository.deleteById(id);
    }

    public Optional<TodoList> findById(Long id) {
        return listRepository.findById(id);
    }
}