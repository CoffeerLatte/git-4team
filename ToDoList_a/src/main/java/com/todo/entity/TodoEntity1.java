package com.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// @Controller 처럼 @Entity라고 작성해야한다.
public class TodoEntity1 {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    @Column(length=10)
	    private String date;

	    @Column(length=200)
	    private String content;

	    @Column(nullable = false)
	    private Boolean completed;
	    
	    
	   // @ManyToOne
	    //@JoinTable(" 회원 정보 num")
	    @Column(unique = true)
	    private Integer customernum;
}