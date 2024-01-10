package com.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.entity.TodoEntity1;
import com.todo.service.TodoServiceImpl1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final TodoServiceImpl1 toDoService;

//	    @RequestMapping("/todo")
//	    public String list(Model model){
//	        List<TodoEntity1> toDoEntityList = this.toDoService.getList();
//	        model.addAttribute("toDoEntityList",toDoEntityList);
//	        return "Todo";
//	    }

	@RequestMapping("/todo")
	public String list(Model model) {
		Integer customerNum = 2; // 이 값은 실제로 전달해야 하는 고객 번호입니다.

		List<TodoEntity1> toDoEntityList = this.toDoService.findByCustomerNum(customerNum);
		model.addAttribute("toDoEntityList", toDoEntityList);
		return "Todo";
	}

	@RequestMapping("/")
	public String root() {
		return "redirect:/todo";
	}

	@PostMapping("/todo/create")
	public String todoCreate(@RequestParam String content, @RequestParam String date, Integer customerNum) {
		customerNum = 2; // 일시적으로 2로 지정
		this.toDoService.create(content, date, customerNum);
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

	@PutMapping("/todo/completedUpdate/{id}")
	public String completedUpdate(@PathVariable Integer id) {
		this.toDoService.completedUpdate(id);
		return "redirect:/todo";
	}

}
