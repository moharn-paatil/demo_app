package com.app.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentRegResponse {
	private String message;
	private LocalDateTime timeStamp;
	public StudentRegResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}

}

