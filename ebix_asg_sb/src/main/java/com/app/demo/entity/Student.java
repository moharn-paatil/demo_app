package com.app.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString //(exclude = "studentCourse")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	//private Course course;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId; 
	@Column(length = 20, unique = true)
	private String username;
	@Column(length = 350)
	private String password;
	
	//@ManyToOne(mappedBy="student")  //user
	//private List<Course> course;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name="student_course" ,
			joinColumns =@JoinColumn(name="Student_Id" , referencedColumnName = "studentId"),
			inverseJoinColumns = @JoinColumn(name="Course_Id" , referencedColumnName = "courseId"))
	private Course course;
}