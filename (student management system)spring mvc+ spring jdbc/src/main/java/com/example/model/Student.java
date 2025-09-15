package com.example.model;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String course;
    private LocalDate enrolledDate;
    
    
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String name, String email, String course, LocalDate enrolledDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
		this.enrolledDate = enrolledDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}
	public void setEnrolledDate(LocalDate enrolledDate) {
		this.enrolledDate = enrolledDate;
	}

}