package com.hitesh.todo.todo_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    //we have to create handler for specific exception
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        System.out.println("Caught exception: " + ex.getMessage());

        ExceptionResponse exception=new ExceptionResponse();
        exception.setMessage(ex.getMessage());
        exception.setStatus(HttpStatus.NOT_FOUND);
        exception.setSuccess(false);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
