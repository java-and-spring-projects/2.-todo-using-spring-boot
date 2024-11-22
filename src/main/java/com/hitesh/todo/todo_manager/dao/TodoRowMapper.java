package com.hitesh.todo.todo_manager.dao;

import com.hitesh.todo.todo_manager.model.Todo;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Todo todo = new Todo();
        todo.setId((int) rs.getInt("id"));
        todo.setTitle((String) rs.getString("title"));
        todo.setContent((String) rs.getString("content"));
        todo.setStatus((String) rs.getString("status"));
        todo.setAddedDate((java.sql.Date) rs.getObject("addedDate"));
        todo.setTodoDate((java.sql.Date) rs.getObject("todoDate"));
        return todo;
    }
}
