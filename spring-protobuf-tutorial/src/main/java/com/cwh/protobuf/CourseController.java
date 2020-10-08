package com.cwh.protobuf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.protobuf.Trainning.Course;
import com.cwh.protobuf.Trainning.Courses;
import com.cwh.protobuf.domain.CoursePojo;
import com.cwh.protobuf.domain.CoursesPojo;

@RestController
public class CourseController {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired 
	CourseRepository2 courseRepository2;
	
	@RequestMapping("/courses/{id}")
	public Course customer(@PathVariable Integer id) {
		return courseRepository.getCourse(id);
	}
	
	@RequestMapping("/courses/list/{size}")
	public Courses cutomers(@PathVariable Integer size) {
		return courseRepository.getCourses(retrieveIds(size));
	}
	
	@RequestMapping("/courses2/{id}")
	public CoursePojo customer2(@PathVariable Integer id) {
		return courseRepository2.getCourse(id);
	}
	
	@RequestMapping("/courses2/list/{size}")
	public List<CoursePojo> cutomers2(@PathVariable Integer size) {
		System.out.println("call22");
		return courseRepository2.getCourses(retrieveIds(size));
	}
	
	
	
	public List<Integer> retrieveIds(int cnt) {
		List<Integer> ids = new ArrayList<>();
		for(int id=0; id<cnt; id++) {
			ids.add(id);
		}
		
		return ids;
	}
}
