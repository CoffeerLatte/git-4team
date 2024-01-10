package com.todo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.Query;

import com.todo.entity.TodoEntity1;

public interface TodoService1 {
	
	// public List<TodoEntity1> getList();
	
	public List<TodoEntity1> findByCustomerNum(Integer Customer_num);
	
	

	public void create(String content, String date);
	
	public void delete(Integer id);
	
	public void update(Integer id, String content);
	
	public void completedUpdate(Integer id);
}
