package com.app.demo.service;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.demo.entity.Course;
import com.app.demo.entity.Student;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomStudentDetails implements UserDetails {
	private Student student;
	private Course course;
	public CustomStudentDetails(Student student) {
		super();
		this.student = student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
		// Meaning : This method should ret Collection(List) of granted authorities ,
		// for a specific user --which will be later stored in Auth obj
		//SimpleGrantedAuthority(String courseName)  imple  GrantedAuthority
		//Student ---> Course	
		
	//return student.getUsername()
				
//		return student.getUsername() //Set<Course>
		 //.stream() //Stream<Course>
		 //.map(course -> new SimpleGrantedAuthority(course.getCourseName()).collect(Collections.toList())); //Stream<SimpleGrantedAuthority>
//		 .collect(Collectors.toList());		
	}

	@Override
	public String getPassword() {
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		return student.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}