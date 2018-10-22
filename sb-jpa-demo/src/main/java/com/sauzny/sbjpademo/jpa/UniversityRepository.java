package com.sauzny.sbjpademo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sauzny.sbjpademo.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long>, JpaSpecificationExecutor<University>{

}
