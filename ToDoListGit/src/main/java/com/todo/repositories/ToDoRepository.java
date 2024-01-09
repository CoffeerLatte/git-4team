package com.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.TodoEntity1;

public interface ToDoRepository extends JpaRepository<TodoEntity1,Integer>{

}
