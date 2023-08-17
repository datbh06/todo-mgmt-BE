package com.yugen.todomgmtbe.controller;

import com.yugen.todomgmtbe.dto.TodoDTO;
import com.yugen.todomgmtbe.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Todo items.
 */
@RestController
@RequestMapping("/api/v1/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;

    /**
     * Creates a new Todo item.
     *
     * @param todoDTO the Todo item to create
     * @return the created Todo item
     */
    @PostMapping("/create")
    public ResponseEntity<TodoDTO> create(@RequestBody TodoDTO todoDTO) {

        TodoDTO savedTodoDTO = todoService.add(todoDTO);

        return new ResponseEntity<>(savedTodoDTO, HttpStatus.CREATED);
    }

    /**
     * Retrieves a Todo item by its id.
     *
     * @param id the id of the Todo item to retrieve
     * @return the retrieved Todo item
     */
    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable Long id) {
        TodoDTO todoDTO = todoService.getTodoById(id);
        return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }
}