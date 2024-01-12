package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todo.entity.TodoEntity2;
import com.todo.service.TeamTodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamTodoController {

	@Autowired
	TeamTodoService teamTodoService;

	@RequestMapping("/session-login/teamtodo")
	public String teamRoot() {	
		return "teamtodo";
	}

	// create
	@PostMapping("/session-login/teamtodo/insert")
	public String insertTodo(@RequestParam int team_id, @RequestParam int personal_id,
			@RequestParam String team_content, @RequestParam String date) {

		TodoEntity2 todo = new TodoEntity2();

		todo.setDate(date);
		todo.setTeam_content(team_content);
		todo.setPersonal_id(personal_id);
		todo.setTeam_id(team_id);
		todo.setCompleted(false);

		this.teamTodoService.insertTodo(todo);
		return "redirect:/session-login/teamtodo";
	}

	// read
	@RequestMapping("session-login/teamtodo/{id}")
	public String list(@PathVariable("id") int team_id, Model model) {
		List<TodoEntity2> toDoEntityList2 = this.teamTodoService.showTodoById(team_id);
		model.addAttribute("toDoEntityList2", toDoEntityList2);
		return "teamtodo";
	}

	// read
	@ResponseBody
	@GetMapping("/get/{id}")
	public List<TodoEntity2> showTodoById(@PathVariable("id") int team_id) {
		return teamTodoService.showTodoById(team_id);
	}

	// update
	@PostMapping("/session-login/teamtodo/update/{team_id}/{content_id}")
	public String updateTodo(@PathVariable("team_id") int team_id, @PathVariable("content_id") int content_id,
			@RequestBody TodoEntity2 todo) {
		teamTodoService.updateTodo(team_id, content_id, todo);
		return "redirect:/session-login/teamtodo";
	}

	@PutMapping("/session-login/teamtodo/updateCompleted/{team_id}/{content_id}")
	public String updateCompleted(@PathVariable int team_id, @PathVariable int content_id) {
		teamTodoService.updateCompleted(team_id, content_id);
		return "redirect:/session-login/teamtodo";
	}

	// delete
	@DeleteMapping("/session-login/teamtodo/delete/{team_id}/{content_id}")
	public String deleteTodo(@PathVariable("team_id") int team_id, @PathVariable("content_id") int content_id) {
		teamTodoService.deleteTodo(team_id, content_id);
		return "redirect:/session-login/teamtodo";
	}
}
