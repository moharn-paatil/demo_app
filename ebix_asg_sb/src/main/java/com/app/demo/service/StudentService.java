package com.app.demo.service;

import javax.validation.Valid;

import com.app.demo.dto.StudentRegResponse;
import com.app.demo.dto.StudentDto;


public interface StudentService {

	StudentRegResponse registerStudent(StudentDto student);

}