package com.todo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
// @Controller 처럼 @Entity라고 작성해야한다.
public class TodoEntity1 {

	
    @Id // 기본키로 설정한다. 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     // 데이터를 저장할 때 해당 속성에 따로 값을
    // 셋팅하지 않아도 1씩 자동으로 증가
    // strategy는 고유 번호를 생성하는 옵션
    // GenerationType.IDENTITY는 해당 컬럼만의
    // 독립적인 시퀀스를 생성하여 번호를 증가시킬 때
    // 사용한다. 
    private Integer id;

    @Column(length=200)
    // Column의 세부 설정을 위해 사용
    private String content;

    @Column(nullable = false)
    private Boolean completed;
    
}