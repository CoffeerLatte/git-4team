package com.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.TodoEntity1;


@Repository
public interface ToDoRepository extends JpaRepository<TodoEntity1,Integer>{
}
