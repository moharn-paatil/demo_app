package com.app.demo.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.demo.dto.StudentDto;
import com.app.demo.dto.StudentRegResponse;
import com.app.demo.entity.Student;
import com.app.demo.dao.ICourseRepository;
import com.app.demo.dao.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	// dep : user repo n role repo
	@Autowired
	private StudentRepository userRepo;
	
	// mapper
	@Autowired
	private ModelMapper mapper;
	// password enc
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public StudentRegResponse registerStudent(StudentDto student) {
		// Objective : 1 rec inserted in users table n insert n recs in link table
		// user_roles
		// 1. Map dto --> entity
		Student studentEntity = mapper.map(student, Student.class);
		// 2. Map Set<UserRole : enum> ---> Set<Role :entity> n assign it to the
		// transient user entity
	//	userEntity.setUserRoles(roleRepo.findByRoleNameIn(user.getRoles()));
		// 3. encode pwd
		studentEntity.setPassword(encoder.encode(student.getPassword()));
		// 4 : Save user details
		Student persistentUser = userRepo.save(studentEntity);
		return new StudentRegResponse("User registered successfully with ID " + persistentUser.getStudentId());
	}

}