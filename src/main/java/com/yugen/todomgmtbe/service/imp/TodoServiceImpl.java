package com.yugen.todomgmtbe.service.imp;

import com.yugen.todomgmtbe.dto.TodoDTO;
import com.yugen.todomgmtbe.entity.Todo;
import com.yugen.todomgmtbe.exception.ResourceNotFoundException;
import com.yugen.todomgmtbe.repository.TodoRepository;
import com.yugen.todomgmtbe.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoDTO add(TodoDTO todoDTO) {

        // Convert TodoDTO to Todo JPA entity using ModelMapper
        Todo todo = modelMapper.map(todoDTO, Todo.class);

        // Todo Jpa entity to be saved in the database
        Todo savedTodo = todoRepository.save(todo);

        // Convert Todo JPA entity to TodoDTO
        return modelMapper.map(savedTodo, TodoDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoDTO getTodoById(Long id) {
        // Get Todo JPA entity from the database using the id
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));
        return modelMapper.map(todo, TodoDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TodoDTO> getAllTodos() {

        // Get all Todo JPA entities from the database
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todo -> modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TodoDTO update(Long id, TodoDTO todoDTO) {

        // Get Todo JPA entity from the database using the id
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        // Update the Todo JPA entity with the new values from the TodoDTO
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.getCompleted());

        // Save the updated Todo JPA entity in the database
        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {
        // Get Todo JPA entity from the database using the id
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        // Delete the Todo JPA entity from the database
        todoRepository.delete(todo);
    }
}
