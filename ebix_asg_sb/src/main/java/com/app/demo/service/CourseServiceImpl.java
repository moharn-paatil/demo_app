package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.entity.Course;
import com.app.demo.dao.ICourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	public ICourseRepository repo;

	@Override
	public Course addCourse(Course course) {
		return repo.save(course);
	}

	@Override
	public void updateCourse(Course updateCourse, int id) {
		Course course = repo.CourseById(id);// edit here for exceptional case like try and catch block you can add if reqd;
		course.setCourseId(id);
		course.setCourseName(updateCourse.getCourseName());         
		course.setCourseTrainer(updateCourse.getCourseTrainer());         
		course.setCourseDuration(updateCourse.getCourseDuration());              
		course.setCourseFee(updateCourse.getCourseFee());         
		repo.save(course);
	}
	
	

	@Override
	public List<Course> getAllCourses() {
		return repo.findAll();	}

	@Override
	public Course deleteCourse(int id) {
		Course deleteCourse = repo.CourseById(id);
		repo.deleteById(deleteCourse.getCourseId());
		return deleteCourse;
	}

}