package com.hitesh.todo.todo_manager.controllers;

import com.hitesh.todo.todo_manager.model.Todo;
import com.hitesh.todo.todo_manager.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        Todo todo1 = todoService.createTodo(todo);
        return todo1;
    }
}
