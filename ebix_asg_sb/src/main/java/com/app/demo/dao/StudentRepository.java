package com.app.demo.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.demo.entity.Student;

@Repository

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("select u from Student u  where u.username=?1") //fetch student details by existing username
	Optional<Student> findByUserName(String username);
}