package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.TodoEntity1;
import com.todo.repositories.TodoRepository_1;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@RestController
public class TodoService1 {
	private final TodoRepository_1 toDoRepository;

	public List<TodoEntity1> getList() {
		return this.toDoRepository.findAll();
	}

	public void create(String content) {
		TodoEntity1 toDoEntity = new TodoEntity1();
		toDoEntity.setContent(content);
		toDoEntity.setCompleted(false);
		this.toDoRepository.save(toDoEntity);
	}
	
	
	
	 public void toggleStatus(Integer id) {
	        try {
	            Optional<TodoEntity1> optionalTodo = toDoRepository.findById(id);
	            if (optionalTodo.isPresent()) {
	                TodoEntity1 todo = optionalTodo.get(); // 해당 id의 Todo를 찾습니다.
	                boolean currentStatus = todo.getCompleted(); // 현재 완료 상태를 가져옵니다.
	                todo.setCompleted(!currentStatus); // 상태를 반전시켜 설정합니다.
	                toDoRepository.save(todo); // 변경된 상태를 저장합니다.
	            } else {
	                // 해당 id의 Todo를 찾지 못했을 때의 처리
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	
	@Transactional
	public void delete(Integer id) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

		this.toDoRepository.delete(toDoEntity);
	}
	
	 @Transactional
	    public void update(Integer id, String content){
	        TodoEntity1 toDoEntity = toDoRepository.findById(id)
	                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

	        toDoEntity.setContent(content);
	        this.toDoRepository.save(toDoEntity);
	    }
	 @Transactional
	    public void updatecomplete(Integer id, boolean completed){
	        TodoEntity1 toDoEntity = toDoRepository.findById(id)
	                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

	        toDoEntity.setCompleted(completed);//setContent(completed);
	        this.toDoRepository.save(toDoEntity);
	    }
	 
	
}