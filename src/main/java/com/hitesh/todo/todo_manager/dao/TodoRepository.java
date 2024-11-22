package com.hitesh.todo.todo_manager.dao;

import com.hitesh.todo.todo_manager.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

}
