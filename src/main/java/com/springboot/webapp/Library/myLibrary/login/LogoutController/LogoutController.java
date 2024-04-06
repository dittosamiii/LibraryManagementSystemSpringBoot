package com.springboot.webapp.Library.myLibrary.login.LogoutController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("name")
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout() {
		// Invalidate the session
		return "logout"; // Redirect to the login page
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String postLogout(@RequestParam(value = "cancel", required = false) String cancel, HttpSession session) {
		if ("true".equals(cancel)) {
			return "redirect:welcome"; // Redirect to the welcome page
		}
		session.invalidate();
		return "redirect:login"; // Redirect to the login page
	}
}
