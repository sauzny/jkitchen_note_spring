package com.sauzny.sbjpademo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;

import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedEntityGraph(name = "teacherWithStudents", attributeNodes = {@NamedAttributeNode("students")})
public class Teacher {

	// 声明主键。
	@Id
	// 声明由程序控制主键生成策略。
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "university_id")
	private Long universityId;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	private Set<Student> students = Sets.newHashSet();
}
