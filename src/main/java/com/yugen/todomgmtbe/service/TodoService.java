package com.yugen.todomgmtbe.service;

import com.yugen.todomgmtbe.dto.TodoDTO;

/**
 * Service interface for managing Todo items.
 */
public interface TodoService {

    /**
     * Adds a new Todo item.
     *
     * @param todoDTO the Todo item to add
     * @return the added Todo item
     */
    TodoDTO add(TodoDTO todoDTO);

    /**
     * Retrieves a Todo item by its id.
     *
     * @param id the id of the Todo item to retrieve
     * @return the retrieved Todo item
     */
    TodoDTO getTodoById(Long id);
}
