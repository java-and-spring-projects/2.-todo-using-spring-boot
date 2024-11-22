package com.hitesh.todo.todo_manager.dao;

import com.hitesh.todo.todo_manager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {
    Logger logger= LoggerFactory.getLogger(TodoDao.class);

    private JdbcTemplate jdbcTemplate;

    public TodoDao(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        //create table if not exists
        String sql="CREATE TABLE IF NOT EXISTS todos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255)," +
                "content TEXT," +
                "status VARCHAR(255)," +
                "addedDate DATE," +
                "todoDate DATE)";

        jdbcTemplate.update(sql);
    }

    //save todo in database
    public Todo saveTodo(Todo todo){
        String sql="INSERT INTO todos (id,title,content,status,addedDate,todoDate) VALUES (?,?,?,?,?,?)";
        int updateRows = jdbcTemplate.update(sql, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(), todo.getAddedDate(), todo.getTodoDate());
        logger.info("update rows "+updateRows);
        return todo;
    }
}
