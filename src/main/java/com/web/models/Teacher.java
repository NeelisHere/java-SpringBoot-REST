package com.web.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Teachers")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherId;
	
	private int name;
	
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "taughtBy", cascade = CascadeType.ALL)
	private List<Course> coursesAssigned;

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCoursesAssigned() {
		return coursesAssigned;
	}

	public void setCoursesAssigned(List<Course> coursesAssigned) {
		this.coursesAssigned = coursesAssigned;
	}
}
