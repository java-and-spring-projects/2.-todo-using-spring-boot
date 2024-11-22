package com.hitesh.todo.todo_manager.controllers;

import com.hitesh.todo.todo_manager.model.Todo;
import com.hitesh.todo.todo_manager.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger= LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    //create todo
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        logger.info("Received todo: {}", todo);
        Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }
    /*
    {
        title":"read",
        content":"read book",
        status":"completed",
        todoDate":"23/12/2025"
    }
    * */


    //get all todos
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    //get single todo
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int todoId) {
        Todo todo = todoService.getTodoById(todoId);

        System.out.println("todo by id: " + todo);
        if (todo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(todo);
    }

    //update todo
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo newTodo, @PathVariable int todoId) {
        Todo todo = todoService.updateTodo(newTodo, todoId);
        return ResponseEntity.ok(todo);
    }

    //delete todo
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(@PathVariable int todoId) {
        logger.debug("delete todo");
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo Deleted Successfully");
    }

    //handle exceptions
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handleException(NullPointerException e) {
//        logger.error("An exception occurred: {}", e.getMessage());
//        return new ResponseEntity<>("An exception occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    //handle exceptions
//    @ExceptionHandler(value = {NullPointerException.class, NumberFormatException.class})
//    public ResponseEntity<String> handleException(Exception e) {
//        logger.error("An exception occurred: {}", e.getMessage());
//        return new ResponseEntity<>("An exception occurred", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
