package com.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.web.models.Student;
import com.web.services.StudentService;


@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return service.getStudents();
	}
	
	@GetMapping("/getStudents/{studentId}")
	public Optional<Student> getStudentById(@PathVariable int studentId) {
		return service.getStudentById(studentId);
	}
	
	@PostMapping("/addStudent")
	public List<Student> addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@PutMapping("/updateStudent")
	public List<Student> updateStudent(@RequestBody Student updatedStudent) {
		return service.updateStudent(updatedStudent);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")
	public List<Student> deleteStudent(@PathVariable int studentId) {
		return service.deleteById(studentId);
	}
}
