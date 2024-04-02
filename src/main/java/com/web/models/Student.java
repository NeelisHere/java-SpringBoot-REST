package com.web.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private int phoneNo;
	
	private String address;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
		name = "student_courses",
		joinColumns = { 
			@JoinColumn(name = "student_id", referencedColumnName = "studentId") 
		}, 
        inverseJoinColumns = { 
    		@JoinColumn(name = "course_id", referencedColumnName = "courseId") 
    	}
	)
	private List<Course>coursesEnrolledIn;
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Course> getCoursesEnrolledIn() {
		return coursesEnrolledIn;
	}
	public void setCoursesEnrolledIn(List<Course> coursesEnrolledIn) {
		this.coursesEnrolledIn = coursesEnrolledIn;
	}
	
}
