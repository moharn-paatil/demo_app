package com.app.demo.dao;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.demo.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer>{
 
	@Query("select c from Course c where id=:id") //fetch course details by its id
	public Course CourseById(int id);

}