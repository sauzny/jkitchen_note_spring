package com.sauzny.sbjpademo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sauzny.sbjpademo.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long>, JpaSpecificationExecutor<University>{

	// join 可修改为  left outer join
	@Query("SELECT u FROM University u LEFT JOIN FETCH u.teachers t LEFT JOIN FETCH t.students WHERE u.id = (:id)")
	University findWithTeachersById(@Param("id") Long id);
}
