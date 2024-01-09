package com.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.entity.TodoEntity1;
import com.todo.repositories.ToDoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ToDoServiceI implements ToDoService {
	private final ToDoRepository toDoRepository;

	@Override
	public List<TodoEntity1> getList() {
		return this.toDoRepository.findAll();
	}

	@Override
	public void create(String content, String date) {
		TodoEntity1 toDoEntity = new TodoEntity1();
		toDoEntity.setContent(content);
		toDoEntity.setCompleted(false);
		toDoEntity.setDate(date);
		this.toDoRepository.save(toDoEntity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

		this.toDoRepository.delete(toDoEntity);
	}

	@Override
	@Transactional
	public void update(Integer id, String content) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

		toDoEntity.setContent(content);
		this.toDoRepository.save(toDoEntity);
	}
	
	@Override
	@Transactional
	public void completedUpdate(Integer id) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));
		toDoEntity.setCompleted(!toDoEntity.getCompleted());
		this.toDoRepository.save(toDoEntity);
	}

}