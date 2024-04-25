
package com.springboot.webapp.Library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.webapp.Library.service.AuthenticationService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class LoginController {

	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@GetMapping("/login")
	public String getLoginPage(ModelMap model) {
		model.put("name", "admin");
		return "login";
	}

	@PostMapping("/login")
	public String authenticateLoginPage(@RequestParam String username, @RequestParam String password,
			HttpSession session, ModelMap model) {
		if (authenticationService.authenticate(username, password)) {
			session.setAttribute("loggedInUser", username);
			return "redirect:welcome";
		}
		model.put("errorMessage", "Invalid Credentials");
		return "login";
	}

	@GetMapping("/welcome")
	public String welcomePage(HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		return "welcome";
	}

}