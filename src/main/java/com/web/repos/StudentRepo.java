package com.web.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
}