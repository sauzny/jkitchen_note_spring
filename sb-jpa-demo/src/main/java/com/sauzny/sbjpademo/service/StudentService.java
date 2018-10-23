package com.sauzny.sbjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.sbjpademo.entity.Student;
import com.sauzny.sbjpademo.jpa.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> addStudent(List<Student> entities) {
		return studentRepository.saveAll(entities);
	}
}
