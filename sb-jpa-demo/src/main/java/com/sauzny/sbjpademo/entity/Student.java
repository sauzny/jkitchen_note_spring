package com.sauzny.sbjpademo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {

    // 声明主键。
    @Id
    // 声明由程序控制主键生成策略。
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "teacher_id")
	private Long teacherId;
}
