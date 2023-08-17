package com.yugen.todomgmtbe.service.imp;

import com.yugen.todomgmtbe.dto.TodoDTO;
import com.yugen.todomgmtbe.entity.Todo;
import com.yugen.todomgmtbe.repository.TodoRepository;
import com.yugen.todomgmtbe.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDTO add(TodoDTO todoDTO) {

        // Convert TodoDTO to Todo JPA entity
        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.getCompleted());

        // Todo Jpa entity to be saved in the database
        Todo savedTodo = todoRepository.save(todo);

        // Convert Todo JPA entity to TodoDTO
        TodoDTO savedTodoDTO = new TodoDTO();
        savedTodoDTO.setId(savedTodo.getId());
        savedTodoDTO.setTitle(savedTodo.getTitle());
        savedTodoDTO.setDescription(savedTodo.getDescription());
        savedTodoDTO.setCompleted(savedTodo.getCompleted());

        return savedTodoDTO;
    }
}
