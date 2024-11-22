package com.hitesh.todo.todo_manager.service;

import com.hitesh.todo.todo_manager.model.Todo;

import java.util.List;

public interface TodoService {
    public Todo createTodo(Todo todo);
    public List<Todo> getAllTodos();
    public Todo getTodoById(int todoId);
    public Todo updateTodo(Todo newTodo, int todoId);
    public void deleteTodo(int todoId);
}
