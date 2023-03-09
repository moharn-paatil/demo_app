package com.app.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.entity.Course;
import com.app.demo.dao.ICourseRepository;
import com.app.demo.service.CourseService;
import com.app.demo.service.CourseServiceImpl;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/Courses")
@Slf4j
public class CourseController {

	@Autowired
	ICourseRepository repo;
	
	@Autowired
	CourseServiceImpl repoImpl;
	
	@Autowired
	CourseService ser;
	
	@Autowired
	public ModelMapper mapper;
	
	@PostMapping("/add") //add new course
	public Course addCourse(@RequestBody Course courses) {
		Course course = mapper.map(courses, Course.class);
		return ser.addCourse(course);
	}
	
	@PutMapping("/update/{id}")  //update course details by id
	public void updateCourse(@RequestBody Course updateCourse, @PathVariable int id ) {
		repoImpl.updateCourse(updateCourse, id);
	
	}
	
	@GetMapping("/getCourse") //get all courses
	public List<Course> course(){
		return repoImpl.getAllCourses();
	}
	
	@DeleteMapping("/delete/{id}")  //delete course by id.
	public Course deleteCourse(@PathVariable int id) {
		return repoImpl.deleteCourse(id);
	}

	
}