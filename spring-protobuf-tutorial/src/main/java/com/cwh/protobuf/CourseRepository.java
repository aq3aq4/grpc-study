package com.cwh.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cwh.protobuf.Trainning.Course;
import com.cwh.protobuf.Trainning.Courses;

public class CourseRepository {
	private final Map<Integer, Course> courses;

	public CourseRepository(Map<Integer, Course> courses) {
		super();
		this.courses = courses;
	}
	
	public Course getCourse(int id) {
		return courses.get(id);
	}
	
	public Courses getCourses(List<Integer> ids) {
		List<Course> c = new ArrayList<>();
		for(int id : ids) {
			c.add(this.courses.get(id));
		}
		
		return Courses.newBuilder().addAllCourses(c).build();
	}
}
