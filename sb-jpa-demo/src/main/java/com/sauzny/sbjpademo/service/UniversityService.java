package com.sauzny.sbjpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sauzny.sbjpademo.entity.University;
import com.sauzny.sbjpademo.jpa.UniversityRepository;

@Service
public class UniversityService {

	@Autowired
	private UniversityRepository universityRepository;
	
	public List<University> addUniversity(List<University> entities) {
		return universityRepository.saveAll(entities);
	}
	
	public University findWithTeachersById(Long id) {
		return universityRepository.findWithTeachersById(id);
	}
}
