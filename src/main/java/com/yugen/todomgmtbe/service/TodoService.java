package com.yugen.todomgmtbe.service;

import com.yugen.todomgmtbe.dto.TodoDTO;

import java.util.List;

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

    /**
     * Retrieves all Todo items.
     *
     * @return the list of all Todo items
     */
    List<TodoDTO> getAllTodos();

    /**
     * Updates a Todo item.
     *
     * @param id      the id of the Todo item to update
     * @param todoDTO the Todo item to update
     * @return the updated Todo item
     */
    TodoDTO update(Long id, TodoDTO todoDTO);

    /**
     * Deletes a Todo item.
     *
     * @param id the id of the Todo item to delete
     */
    void delete(Long id);

    /**
     * Updates the status completed of a Todo item.
     *
     * @param id the id of the Todo item to update
     * @return the updated completed status of Todo item
     */
    TodoDTO updateStatusCompleted(Long id);

    /**
     * Updates the status uncompleted of a Todo item.
     *
     * @param id the id of the Todo item to update
     * @return the updated uncompleted  status of Todo item
     */
    TodoDTO updateStatusUncompleted(Long id);
}
