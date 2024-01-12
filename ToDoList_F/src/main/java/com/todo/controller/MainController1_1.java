/*
 * package com.todo.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * import com.todo.entity.TodoEntity1; import com.todo.service.TodoService1;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @RequiredArgsConstructor
 * 
 * @Controller public class MainController1_1 {
 * 
 * private final TodoService1 toDoService;
 * 
 * @RequestMapping("/todo") public String list(Model model) { List<TodoEntity1>
 * toDoEntityList = this.toDoService.getList();
 * model.addAttribute("toDoEntityList", toDoEntityList); return "Todo"; }
 * 
 * @RequestMapping("/") public String root() { return "redirect:/todo"; }
 * 
 * @PostMapping("/todo/create") public String todoCreate(@RequestParam String
 * content) { this.toDoService.create(content); return "redirect:/todo"; } }
 */