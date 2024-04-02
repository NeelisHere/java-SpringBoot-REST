package com.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.models.Student;
import com.web.repos.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo repo;
	
	public List<Student> addStudent(Student student) {
		repo.save(student);
		return repo.findAll();
	}

	public List<Student> getStudents() {
		return repo.findAll();
	}

	public Optional<Student> getStudentById(int studentId) {
		return repo.findById(studentId);
	}

	public List<Student> updateStudent(Student updatedStudent) {
		repo.save(updatedStudent);
		return repo.findAll();
	}

	public List<Student> deleteById(int studentId) {
		repo.deleteById(studentId);
		return repo.findAll();
	}
}
