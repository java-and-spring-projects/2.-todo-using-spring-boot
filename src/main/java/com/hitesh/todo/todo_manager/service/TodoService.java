package com.hitesh.todo.todo_manager.service;

import com.hitesh.todo.todo_manager.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TodoService {
    List<Todo> todos=new ArrayList<>();

    Random random=new Random();

    public Todo createTodo(Todo todo) {
        int id=random.nextInt(1000000);
        todo.setId(id);
        todos.add(todo);
        return todo;
    }
}
