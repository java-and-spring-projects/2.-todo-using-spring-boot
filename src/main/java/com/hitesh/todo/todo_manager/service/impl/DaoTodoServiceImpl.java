package com.hitesh.todo.todo_manager.service.impl;

import com.hitesh.todo.todo_manager.dao.TodoDao;
import com.hitesh.todo.todo_manager.exceptions.ResourceNotFoundException;
import com.hitesh.todo.todo_manager.model.Todo;
import com.hitesh.todo.todo_manager.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Primary
public class DaoTodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;

    @Override
    public Todo createTodo(Todo todo) {
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoDao.getAllTodos();
    }

    @Override
    public Todo getTodoById(int todoId) {
        return todoDao.getTodoById(todoId);
    }

    @Override
    public Todo updateTodo(Todo newTodo, int todoId) {
        return todoDao.updateTodo(todoId, newTodo);
    }

    @Override
    public void deleteTodo(int todoId) {
        todoDao.deleteTodo(todoId);
    }
}
