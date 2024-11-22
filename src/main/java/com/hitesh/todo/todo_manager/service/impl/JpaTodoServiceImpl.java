package com.hitesh.todo.todo_manager.service.impl;

import com.hitesh.todo.todo_manager.dao.TodoDao;
import com.hitesh.todo.todo_manager.dao.TodoRepository;
import com.hitesh.todo.todo_manager.exceptions.ResourceNotFoundException;
import com.hitesh.todo.todo_manager.model.Todo;
import com.hitesh.todo.todo_manager.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class JpaTodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoById(int todoId) {
        return todoRepository.findById(todoId).orElseThrow(()->new ResourceNotFoundException("No such todo", HttpStatus.NOT_FOUND));
    }

    @Override
    public Todo updateTodo(Todo newTodo, int todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No such todo", HttpStatus.NOT_FOUND));
        todo.setTitle(newTodo.getTitle());
        todo.setContent(newTodo.getContent());
        todo.setStatus(newTodo.getStatus());
        Todo updatedTodo = todoRepository.save(todo);

        return updatedTodo;
    }

    @Override
    public void deleteTodo(int todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new ResourceNotFoundException("No such todo", HttpStatus.NOT_FOUND));
        todoRepository.delete(todo);
    }
}
