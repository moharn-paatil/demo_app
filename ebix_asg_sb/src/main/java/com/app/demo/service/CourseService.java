package com.app.demo.service;

import java.util.List;

import com.app.demo.entity.Course;



public interface CourseService {

Course addCourse (Course course);
	
	public void updateCourse(Course updateCourse, int id);
	
	public List<Course> getAllCourses();
	
	public Course deleteCourse(int id);
}