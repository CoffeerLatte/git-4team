package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity3;

public interface PersonalTodoService {
	// c
	TodoEntity3 insertTodo(TodoEntity3 todo);

	// r
	// TodoEntity2 showTodoAll();
	List<TodoEntity3> showTodoById(int persoanl_id);

	// u
	TodoEntity3 updateTodo(int team_id, int content_id, TodoEntity3 todo);

	// d
	void deleteTodo(int team_id, int content_id);
}
