package com.hitesh.todo.todo_manager.dao;

import com.hitesh.todo.todo_manager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TodoDao {
    Logger logger = LoggerFactory.getLogger(TodoDao.class);

    private JdbcTemplate jdbcTemplate;

    public TodoDao(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        //create table if not exists
        String sql = "CREATE TABLE IF NOT EXISTS todos (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "title VARCHAR(255)," +
                "content TEXT," +
                "status VARCHAR(255)," +
                "addedDate DATE," +
                "todoDate DATE)";

        jdbcTemplate.update(sql);
    }

    //save todo in database
    public Todo saveTodo(Todo todo) {
        String sql = "INSERT INTO todos (id,title,content,status,addedDate,todoDate) VALUES (?,?,?,?,?,?)";
        int updateRows = jdbcTemplate.update(sql, todo.getId(), todo.getTitle(), todo.getContent(), todo.getStatus(), todo.getAddedDate(), todo.getTodoDate());
        return todo;
    }

    //get single todo
    public Todo getTodoById(int id) {
        String sql = "SELECT * FROM todos WHERE id=?";
        Map<String, Object> todoData = jdbcTemplate.queryForMap(sql, id);


        Todo todo = new Todo();
        todo.setId((int) todoData.get("id"));
        todo.setTitle((String) todoData.get("title"));
        todo.setContent((String) todoData.get("content"));
        todo.setStatus((String) todoData.get("status"));
        todo.setAddedDate((java.sql.Date) todoData.get("addedDate"));
        todo.setTodoDate((java.sql.Date) todoData.get("todoDate"));

        return todo;

    }

    //get all todos
    public List<Todo> getAllTodos() {
        String sql = "SELECT * FROM todos";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        List<Todo> todos= maps.stream().map((todoData)-> {
            Todo todo = new Todo();
            todo.setId((int) todoData.get("id"));
            todo.setTitle((String) todoData.get("title"));
            todo.setContent((String) todoData.get("content"));
            todo.setStatus((String) todoData.get("status"));
            todo.setAddedDate((java.sql.Date) todoData.get("addedDate"));
            todo.setTodoDate((java.sql.Date) todoData.get("todoDate"));

            return todo;
        }).collect(Collectors.toList());

        return todos;
    }

    //update todo
    public Todo updateTodo(int id, Todo newTodo){
        String sql = "UPDATE todos SET title=?, content=?, status=?, todoDate=? WHERE id=?";
        int updateRows = jdbcTemplate.update(sql, newTodo.getTitle(), newTodo.getContent(), newTodo.getStatus(), newTodo.getTodoDate(), id);
        logger.info("update rows " + updateRows);

        newTodo.setId(id);
        return newTodo;
    }
}
