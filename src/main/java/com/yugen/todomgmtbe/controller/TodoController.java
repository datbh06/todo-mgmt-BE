package com.yugen.todomgmtbe.controller;

import com.yugen.todomgmtbe.dto.TodoDTO;
import com.yugen.todomgmtbe.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    // Build Add Todo REST API
    @PostMapping("/create")
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO todoDTO) {

        TodoDTO savedTodoDTO = todoService.add(todoDTO);

        return new ResponseEntity<>(savedTodoDTO, HttpStatus.CREATED);
    }

    // Build Get Todo REST API by Id
    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.getTodoById(id);
        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }
}
