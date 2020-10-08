package com.cwh.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cwh.protobuf.domain.CoursePojo;
import com.cwh.protobuf.domain.CoursesPojo;

public class CourseRepository2 {
	private final Map<Integer, CoursePojo> courses;

	public CourseRepository2(Map<Integer, CoursePojo> courses) {
		this.courses = courses;
	}
	
	public CoursePojo getCourse(int id) {
		return courses.get(id);
	}
	
	public List<CoursePojo> getCourses(List<Integer> ids) {
//		Courses2 list = new Courses2();
		List<CoursePojo> t = new ArrayList<>();
		for(int id : ids) {
			t.add(this.courses.get(id));
		}
		
//		list.setCourses(t);
		
		return t;
	}
}
