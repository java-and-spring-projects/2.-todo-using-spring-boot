package com.hitesh.todo.todo_manager.exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public ResourceNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
