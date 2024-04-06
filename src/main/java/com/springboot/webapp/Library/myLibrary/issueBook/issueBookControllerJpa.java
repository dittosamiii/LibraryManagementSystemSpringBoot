package com.springboot.webapp.Library.myLibrary.issueBook;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class issueBookControllerJpa {

	private issueBookRepository issueBookRepo;

	// To inject we are using this constructor
	public issueBookControllerJpa(issueBookRepository issueBookRepo) {

		super();
		this.issueBookRepo = issueBookRepo;
	}

	@RequestMapping("issue")
	public String issueBooksPage(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		List<issueBooks> issueBooks = issueBookRepo.findByUsername(username);
		model.addAttribute("issueBook", issueBooks);
		return "issue";

	}

	@RequestMapping(value = "/issue-book", method = RequestMethod.GET)
	public String issuingBooks(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		issueBooks book = new issueBooks(username, 0, 0, "", "", LocalDate.now(), LocalDate.now());
		model.put("issueBook", book);
		return "issue-book";

	}

	@RequestMapping(value = "/issue-book", method = RequestMethod.POST)
	public String returnissueBooks(@Valid issueBooks book, BindingResult result, ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		if (result.hasErrors()) {
			model.put("issueBook", book);
			return "issue-book";
		}
		String username = (String) model.get("name");
		book.setUsername(username);
		issueBookRepo.save(book);
		return "redirect:issue";

	}

	@RequestMapping(value = "/delete-issue-book")
	public String deleteBooks(@RequestParam int bookId, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		issueBookRepo.deleteById(bookId);
		return "redirect:issue";

	}

}
