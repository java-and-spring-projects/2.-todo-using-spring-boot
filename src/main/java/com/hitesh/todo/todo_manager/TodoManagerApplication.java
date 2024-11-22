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
public class TodoManagerApplication{


	public static void main(String[] args) {
		SpringApplication.run(TodoManagerApplication.class, args);
	}

}
