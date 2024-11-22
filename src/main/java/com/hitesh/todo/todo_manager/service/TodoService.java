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

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getTodoById(int todoId) {
        for (Todo todo : todos) {
            if (todo.getId() == todoId) {
                return todo;
            }
        }
        return null;
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
