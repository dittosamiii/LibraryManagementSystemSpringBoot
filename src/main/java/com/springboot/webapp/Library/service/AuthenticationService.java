package com.springboot.webapp.Library.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("admin");
		boolean isValidPassword = password.equalsIgnoreCase("admin");

		return (isValidUserName && isValidPassword);
	}
}
