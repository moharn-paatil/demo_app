package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.demo.entity.Student;
import com.app.demo.dao.StudentRepository;

@Service 
@Transactional
@ComponentScan
@Component
public class CustomStudentDetailsService implements UserDetailsService {
	// dep : user repository : based upon spring data JPA
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in load by user nm " + username);
		// invoke dao's method to load user details from db by username(ie. actaully an
		// email)
		Student student = studentRepo.
				findByUserName(username).
				orElseThrow(() -> new UsernameNotFoundException("Invalid username  "));
		System.out.println("lifted student dtls from db "+student);
		return new CustomStudentDetails(student);
	}

}