package com.cwh.protobuf.domain;

import java.util.List;

public class CoursePojo {
	private int id;
	private String courseName;
	private List<StudentPojo> student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<StudentPojo> getStudent() {
		return student;
	}
	public void setStudent(List<StudentPojo> student) {
		this.student = student;
	}
	
}
