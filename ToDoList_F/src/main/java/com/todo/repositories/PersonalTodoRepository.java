package com.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.entity.TodoEntity3;

@Repository
public interface PersonalTodoRepository extends JpaRepository<TodoEntity3, Integer> {

	@Query(value = "SELECT * FROM todo_entity3 where personal_id = ?", nativeQuery = true)
	List<TodoEntity3> getTodoById(int personal_id);

	@Query(value = "SELECT * FROM todo_entity3 where team_id = ? and content_id = ?", nativeQuery = true)
	TodoEntity3 showTodoUpdate(int personal_id, int content_id);

	@Query(value = "DELETE FROM todo_entity3 where team_id = ? and content_id = ?", nativeQuery = true)
	void deleteTodoById(int personal_id, int content_id);
	
	/*
	 * @Query(value =
	 * "UPDATE todo_entity2 set completed = ?, date = ?, team_content = ? where team_id = ? and content_id = ?"
	 * , nativeQuery = true) TodoEntity2 updateTodo(int team_id, int content_id);
	 */

}
