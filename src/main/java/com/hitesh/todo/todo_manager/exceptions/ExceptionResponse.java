package com.hitesh.todo.todo_manager.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
}
