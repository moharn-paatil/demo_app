package com.app.demo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class Course {
	
	//private Student student;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId ; 
	private String courseName; 
	private String courseTrainer; 
	private double courseFee ;
	private double courseDuration ;
	
	//@OneToMany
	@ManyToOne
	@JoinColumn(name="studentId")
	private Student student;
//	public int getStudentId() {
//		return student.getStudentId();
//	}

}