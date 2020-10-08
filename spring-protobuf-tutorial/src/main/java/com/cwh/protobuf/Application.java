package com.cwh.protobuf;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.cwh.protobuf.Trainning.Course;
import com.cwh.protobuf.Trainning.Student;
import com.cwh.protobuf.Trainning.Student.PhoneNumber;
import com.cwh.protobuf.Trainning.Student.PhoneType;
import com.cwh.protobuf.domain.CoursePojo;
import com.cwh.protobuf.domain.PhoneNumberPojo;
import com.cwh.protobuf.domain.PhoneTypePojo;
import com.cwh.protobuf.domain.StudentPojo;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean(name="protoBufRestTemplate")
    RestTemplate protoBufRestTemplate(ProtobufHttpMessageConverter hmc) {
        RestTemplate restTemplate =  new RestTemplate(Arrays.asList(hmc));
        return restTemplate;
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }
    
    @Bean
    RestTemplate restTemplate() {
    		return new RestTemplate();
    }

    @Bean
    public CourseRepository createTestCourses() {
        Map<Integer, Course> courses = new HashMap<>();

        for(int i=0; i<10000; i++) {
        		Course course = Course.newBuilder().setId(i).setCourseName("REST with Spring" + i).addAllStudent(createTestStudents()).build();
        		courses.put(course.getId(), course);
        }

        return new CourseRepository(courses);
    }
    
    private List<Student> createTestStudents() {
        PhoneNumber phone1 = createPhone("123456", PhoneType.MOBILE);
        Student student1 = createStudent(1, "조", "우현", "aq3aq4@gmail.com", Arrays.asList(phone1));

        PhoneNumber phone2 = createPhone("234567", PhoneType.LANDLINE);
        Student student2 = createStudent(2, "아", "이언맨", "ironman@gmail.com", Arrays.asList(phone2));

        PhoneNumber phone3_1 = createPhone("345678", PhoneType.MOBILE);
        PhoneNumber phone3_2 = createPhone("456789", PhoneType.LANDLINE);
        Student student3 = createStudent(3, "토", "", "tor@gmail.com", Arrays.asList(phone3_1, phone3_2));

        return Arrays.asList(student1, student2, student3);
    }

    private Student createStudent(int id, String firstName, String lastName, String email, List<PhoneNumber> phones) {
        return Student.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email).addAllPhone(phones).build();
    }

    private PhoneNumber createPhone(String number, PhoneType type) {
        return PhoneNumber.newBuilder().setNumber(number).setType(type).build();
    }
    
    @Bean 
    public CourseRepository2 createTestCourse2() {
    		Map<Integer, CoursePojo> courses = new HashMap<>();
    		for(int i=0; i<10000; i++) {
        		CoursePojo course = new CoursePojo();
        		course.setId(i);
        		course.setCourseName("REST with Spring" + i);
        		course.setStudent(createTest2Student());
        		
        		courses.put(course.getId(), course);
        }

        return new CourseRepository2(courses);
    }
    
    private List<StudentPojo> createTest2Student() {
    		
    		PhoneNumberPojo phone1 = createPhone2("123456", PhoneTypePojo.MOBILE);
    		StudentPojo student1 = createStudent2(1, "조", "우현", "aq3aq4@gmail.com", Arrays.asList(phone1));
    		
    		PhoneNumberPojo phone2 = createPhone2("234567", PhoneTypePojo.LANDLINE);
        StudentPojo student2 = createStudent2(2, "아", "이언맨", "ironman@gmail.com", Arrays.asList(phone2));
        
        PhoneNumberPojo phone3_1 = createPhone2("345678", PhoneTypePojo.MOBILE);
        PhoneNumberPojo phone3_2 = createPhone2("456789", PhoneTypePojo.LANDLINE);
        StudentPojo student3 = createStudent2(3, "토", "", "tor@gmail.com", Arrays.asList(phone3_1, phone3_2));
        
        return Arrays.asList(student1, student2, student3);
    }
    
    private StudentPojo createStudent2(int id, String firstName, String lastName, String email, List<PhoneNumberPojo> phones) {
    		StudentPojo student = new StudentPojo();
    		student.setId(id);
    		student.setFirstName(firstName);
    		student.setLastName(lastName);
    		student.setPhone(phones);
    		
    		return student;
    }
    
    private PhoneNumberPojo createPhone2(String number, PhoneTypePojo type) {
    		PhoneNumberPojo phoneNumber2 = new PhoneNumberPojo();
    		phoneNumber2.setNumber(number);
    		phoneNumber2.setType(type);
    		return phoneNumber2;
    }
}
