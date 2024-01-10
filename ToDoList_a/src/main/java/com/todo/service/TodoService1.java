package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity1;

public interface TodoService1 {

	// public List<TodoEntity1> getList();

	public List<TodoEntity1> findByCustomerNum(Integer Customer_num);

	public void create(String content, String date, Integer customerNum);

	public void delete(Integer id);

	public void update(Integer id, String content);

	public void completedUpdate(Integer id);
}
