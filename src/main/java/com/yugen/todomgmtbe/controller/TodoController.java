package com.yugen.todomgmtbe.controller;

import com.yugen.todomgmtbe.dto.TodoDTO;
import com.yugen.todomgmtbe.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO todoDTO) {

        TodoDTO savedTodoDTO = todoService.add(todoDTO);

        return new ResponseEntity<>(savedTodoDTO, HttpStatus.CREATED);
    }
}
