package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.TodoEntity2;
import com.todo.repositories.TeamTodoRepository;

@Service
public class TeamTodoServiceImpl implements TeamTodoService {

	@Autowired
	TeamTodoRepository teamTodoRepository;
	
	// create
	@Override
	public TodoEntity2 insertTodo(TodoEntity2 todo) {
		return teamTodoRepository.save(todo);
	}

	// read 
	@Override
	public List<TodoEntity2> showTodoById(int team_id) {
		return teamTodoRepository.getTodoById(team_id);
	}

	
	// update
	@Override
	public TodoEntity2 updateTodo(int team_id, int content_id, TodoEntity2 todo) {
		
		TodoEntity2 entity = teamTodoRepository.showTodoUpdate(team_id, content_id);
		
		entity.setCompleted(todo.getCompleted());
		entity.setDate(todo.getDate());
		entity.setTeam_content(todo.getTeam_content());
		
		teamTodoRepository.save(entity);
		
		return entity;
	}

	
	// delete
	@Override
	public void deleteTodo(int team_id, int content_id) {
		teamTodoRepository.deleteTodoById(team_id, content_id);
	}


}
