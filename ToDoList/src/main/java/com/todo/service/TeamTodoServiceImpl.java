package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.TodoEntity1;
import com.todo.entity.TodoEntity2;
import com.todo.repositories.TeamTodoRepository;

import jakarta.transaction.Transactional;

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
	public void updateTodo(int team_id, int content_id, TodoEntity2 todo) {
		
		TodoEntity2 entity = teamTodoRepository.showTodoUpdate(team_id, content_id);
		
		/*
		 * entity.setCompleted(false); entity.setDate(todo.getDate());
		 */
		entity.setDate(todo.getDate());
		entity.setTeam_content(todo.getTeam_content());
		teamTodoRepository.save(entity);
	}

	@Transactional
	public void updateCompleted(int team_id, int content_id) {
		TodoEntity2 toDoEntity = teamTodoRepository.showTodoUpdate(team_id, content_id);

		toDoEntity.setCompleted(!toDoEntity.getCompleted());
		this.teamTodoRepository.save(toDoEntity);
	}
	
	// delete
	@Override
	public void deleteTodo(int team_id, int content_id) {
		teamTodoRepository.deleteTodoById(team_id, content_id);
	}
	
	


}
