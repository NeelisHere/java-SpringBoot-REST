package com.web.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Courses")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseId;
	
	private String title;
	
	private String description;
	
	@ManyToMany(mappedBy = "coursesEnrolledIn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> studentsEnrolledIn;
	
	@OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
	@JoinColumn(name = "materialId")
	private CourseMaterial courseMaterial;
	
	@ManyToOne
	@JoinColumn(name = "teacherId")
	private Teacher taughtBy;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Student> getStudentsEnrolledIn() {
		return studentsEnrolledIn;
	}

	public void setStudentsEnrolledIn(List<Student> studentsEnrolledIn) {
		this.studentsEnrolledIn = studentsEnrolledIn;
	}

	public CourseMaterial getCourseMaterial() {
		return courseMaterial;
	}

	public void setCourseMaterial(CourseMaterial courseMaterial) {
		this.courseMaterial = courseMaterial;
	}

	public Teacher getTaughtBy() {
		return taughtBy;
	}

	public void setTaughtBy(Teacher taughtBy) {
		this.taughtBy = taughtBy;
	}
	
	
}
