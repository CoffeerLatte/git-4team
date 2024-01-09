package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity2;

public interface TeamTodoService {
	// c
	TodoEntity2 insertTodo(TodoEntity2 todo);
	// r
	//TodoEntity2 showTodoAll();
	List<TodoEntity2> showTodoById(int team_id); 
	// u
	TodoEntity2 updateTodo(int team_id, int content_id, TodoEntity2 todo);
	// d
	void deleteTodo(int team_id, int content_id);
}
