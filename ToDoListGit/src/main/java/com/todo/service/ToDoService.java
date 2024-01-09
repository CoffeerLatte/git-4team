package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity1;

public interface ToDoService {
	
	public List<TodoEntity1> getList();
	
	public void create(String content, String date);
	
	public void delete(Integer id);
	
	public void update(Integer id, String content);
	
	public void completedUpdate(Integer id);
}
