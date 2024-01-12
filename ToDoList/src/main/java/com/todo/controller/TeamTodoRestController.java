package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.TodoEntity2;
import com.todo.service.TeamTodoService;

@RestController
@RequestMapping("team")
public class TeamTodoRestController {
	
	@Autowired
	TeamTodoService teamTodoService;

	// create
	@PostMapping("/insert")
	public TodoEntity2 insertTodo(@RequestBody TodoEntity2 todo) {
		return teamTodoService.insertTodo(todo);
	}

	// read 
	@GetMapping("/get/{id}")
	public List<TodoEntity2> showTodoById(@PathVariable("id") int team_id) {
		return teamTodoService.showTodoById(team_id);
	}

	
	// update
	@PostMapping("/update/{team_id}/{content_id}")
	public void updateTodo(@PathVariable("team_id") int team_id,
								@PathVariable("content_id") int content_id, 
								@RequestBody TodoEntity2 todo) {
		teamTodoService.updateTodo(team_id, content_id, todo);
	}

	
	// delete
	@GetMapping("/delete/{team_id}/{content_id}")
	public void deleteTodo(@PathVariable("team_id") int team_id,
						@PathVariable("content_id") int content_id) {
		teamTodoService.deleteTodo(team_id, content_id);
	}
}
