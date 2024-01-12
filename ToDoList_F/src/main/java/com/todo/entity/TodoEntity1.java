package com.todo.entity;

import java.io.Serializable;

import com.todo.security.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// @Controller 처럼 @Entity라고 작성해야한다.
public class TodoEntity1 implements Serializable {

	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
	    @Column(length=10)
	    private String date;

	    @Column(length=200)
	    private String content;

	    @Column(nullable = false)
	    private Boolean completed;
	    
	    
	   
	    private Long customernum;
	   
	    
	    
//	    @ManyToOne
//	    @JoinColumn(name= "num")
//	    private User user;
	    
	    
}