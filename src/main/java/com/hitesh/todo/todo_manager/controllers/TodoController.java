package com.hitesh.todo.todo_manager.controllers;

import com.hitesh.todo.todo_manager.model.Todo;
import com.hitesh.todo.todo_manager.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger= LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        logger.info("Received todo: {}", todo);
        Todo todo1 = todoService.createTodo(todo);
        return todo1;
    }
}
