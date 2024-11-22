package com.hitesh.todo.todo_manager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String title;
    private String content;
    private String status;
    private Date addedDate;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date todoDate;
}
