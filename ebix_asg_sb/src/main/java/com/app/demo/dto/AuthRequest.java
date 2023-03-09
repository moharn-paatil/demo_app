package com.app.demo.dto;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthRequest {
	@NotBlank(message = "Username for login can't be blank or null")
	private String username;
	@NotBlank(message = "Password is necessary for Login")
	private String password;
}