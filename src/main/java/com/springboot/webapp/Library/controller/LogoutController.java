package com.springboot.webapp.Library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class LogoutController {

	@GetMapping("/logout")
	public String getLogout() {
		// Invalidate the session
		return "logout"; // Redirect to the login page
	}

	@PostMapping("/logout")
	public String postLogout(@RequestParam(value = "cancel", required = false) String cancel, HttpSession session) {
		if ("true".equals(cancel)) {
			return "redirect:welcome"; // Redirect to the welcome page
		}
		session.invalidate();
		return "redirect:login"; // Redirect to the login page
	}
}
