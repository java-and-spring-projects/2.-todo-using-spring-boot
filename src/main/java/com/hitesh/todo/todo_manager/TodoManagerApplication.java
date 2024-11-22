package com.hitesh.todo.todo_manager;

import com.hitesh.todo.todo_manager.dao.TodoDao;
import com.hitesh.todo.todo_manager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {

	@Autowired
    TodoDao todoDao;

	Logger logger= LoggerFactory.getLogger(TodoManagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

	public void run(String... args) throws Exception {
//		Todo todo = new Todo();
//		todo.setId(12);
//		todo.setTitle("First Todo");
//		todo.setContent("This is my first todo");
//		todo.setStatus("pending");
//		todo.setAddedDate(new Date());
//		todo.setTodoDate(new Date());
//
//		logger.info("saved");
//		todoDao.saveTodo(todo);


		//get todo
//		Todo todo = todoDao.getTodoById(12);
//		logger.info("get todo data {}", todo);


		//get all todos
//		Iterable<Todo> todoList = todoDao.getAllTodos();
//        logger.info("get todo list {}", todoList);


		//update todo
//		Todo todoById = todoDao.getTodoById(12);
//		todoById.setTitle("Updated Title");
//		todoById.setContent("Updated");
//		todoById.setStatus("pending");
//		todoById.setTodoDate(new Date());
//		todoById.setAddedDate(new Date());
//		todoDao.updateTodo(12,todoById);

		//delete todo
		todoDao.deleteTodo(12);

	}


}
