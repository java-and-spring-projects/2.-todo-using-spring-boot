package com.hitesh.todo.todo_manager.service.impl;

import com.hitesh.todo.todo_manager.exceptions.ResourceNotFoundException;
import com.hitesh.todo.todo_manager.model.Todo;
import com.hitesh.todo.todo_manager.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TodoServiceImpl implements TodoService {
    List<Todo> todos=new ArrayList<>();

    Random random=new Random();

    public Todo createTodo(Todo todo) {
        int id=random.nextInt(1000000);
        todo.setId(id);
        todo.setAddedDate(new Date());
        todos.add(todo);
        return todo;
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodoById(int todoId) {
        Todo todo= todos.stream()
                .filter(t-> todoId==t.getId())
                .findAny()
                .orElseThrow(()->new ResourceNotFoundException("todo not found for given id", HttpStatus.NOT_FOUND));
        return todo;
    }

    public Todo updateTodo(Todo newTodo, int todoId) {
        Todo todo = getTodoById(todoId);
        if (todo!=null) {
            todo.setTitle(newTodo.getTitle());
            todo.setContent(newTodo.getContent());
            todo.setStatus(newTodo.getStatus());
        }
        return todo;
    }

    public void deleteTodo(int todoId) {
        Todo todo = getTodoById(todoId);
        if (todo!=null) {
            todos.remove(todo);
        }
    }
}
