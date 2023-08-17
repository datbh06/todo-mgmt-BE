package com.yugen.todomgmtbe.service.imp;

import com.yugen.todomgmtbe.dto.TodoDTO;
import com.yugen.todomgmtbe.entity.Todo;
import com.yugen.todomgmtbe.repository.TodoRepository;
import com.yugen.todomgmtbe.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDTO add(TodoDTO todoDTO) {

        // Convert TodoDTO to Todo JPA entity using ModelMapper
        Todo todo = modelMapper.map(todoDTO, Todo.class);

        // Todo Jpa entity to be saved in the database
        Todo savedTodo = todoRepository.save(todo);

        // Convert Todo JPA entity to TodoDTO
        return modelMapper.map(savedTodo, TodoDTO.class);
    }
}
