package com.sauzny.sbjpademo.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.sauzny.sbjpademo.entity.Teacher;
import com.sauzny.sbjpademo.jpa.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<Teacher> addTeacher(List<Teacher> entities) {
		return teacherRepository.saveAll(entities);
	}
	
	public Teacher addTeacher(Teacher entity) {
		return teacherRepository.saveAndFlush(entity);
	}
	
	public Teacher findWithTeachersById(Long id) {
		return teacherRepository.findWithStudentsById(id);
	}
	
	public Teacher findByIdAndFetchStudentsEagerly(Long id) {
		return teacherRepository.findByIdAndFetchStudentsEagerly(id);
	}
	
	public List<Teacher> findAll(List<String> names){
		return teacherRepository.findAll(TeacherSpecification.queryWithNames(names));
	}
	
	public Page<Teacher> findAll(Pageable pageable){
		return teacherRepository.findAll(pageable);
	}
	
	public Page<Teacher> findAll(String name, Integer number, Integer size){
		return teacherRepository.findAll(TeacherSpecification.query(name), PageRequest.of(number, size, new Sort(Sort.Direction.DESC, "createTime")));
	}
	
}


//查询参数详细
class TeacherSpecification {
	
	public static Specification<Teacher> queryWithNames(List<String> names){
	     
	     return ((root, query, criteriaBuilder) -> {
	         
	         List<Predicate> predicates = Lists.newLinkedList();
	         
	         if (names != null && names.size() > 0) {
	        	 CriteriaBuilder.In<String> in = criteriaBuilder.in(root.get("name"));
	        	 names.forEach(name -> in.value(name));
	        	 predicates.add(in);
	         }
	         
	         return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	     });
	}
	
	public static Specification<Teacher> query(String name){
     
     return ((root, query, criteriaBuilder) -> {
         
         List<Predicate> predicates = Lists.newLinkedList();
         
         if (name != null) {
             predicates.add(criteriaBuilder.equal(root.get("name"), name));
         }
         
         return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
     });
 }
}
