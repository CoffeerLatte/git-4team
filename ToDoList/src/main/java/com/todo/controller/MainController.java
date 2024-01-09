package com.todo.controller;

import java.util.List;

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

import com.todo.entity.TodoEntity1;
import com.todo.service.TodoService1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final TodoService1 toDoService;
	

	@RequestMapping("/todo")
	public String list(Model model) {
		List<TodoEntity1> toDoEntityList = this.toDoService.getList();
		model.addAttribute("toDoEntityList", toDoEntityList);
		return "Todo";
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/todo";
	}

	@PutMapping("/todo/toggle/{id}")
	public String toggleTodoStatus(@PathVariable Integer id) {
	    this.toDoService.toggleStatus(id);
	    return "redirect:/todo";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@PostMapping("/todo/create")
	public String todoCreate(@RequestParam String content) {
		this.toDoService.create(content);
		return "redirect:/todo";
	}

	@DeleteMapping("/todo/delete/{id}")
	public String todoDelete(@PathVariable Integer id) {
		this.toDoService.delete(id);
		return "redirect:/todo";
	}

	@PutMapping("/todo/update/{id}")
	public String todoUpdate(@RequestBody String content, @PathVariable Integer id) {
		this.toDoService.update(id, content);
		return "redirect:/todo";
	}
	@PutMapping("/todo/updatecomplete/{id}")
	public String todoUpdate(@RequestBody boolean completed, @PathVariable Integer id) {
		this.toDoService.updatecomplete(id, completed);
		return "redirect:/todo";
	}

}
