package com.sauzny.sbjpademo.jpa;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sauzny.sbjpademo.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>, JpaSpecificationExecutor<Teacher>{

	@EntityGraph(attributePaths = { "students" })
	Teacher findWithStudentsById(Long id);
	
	// join 可修改为  left outer join
	@Query("SELECT t FROM Teacher t JOIN FETCH t.students WHERE t.id = (:id)")
    Teacher findByIdAndFetchStudentsEagerly(@Param("id") Long id);
}
