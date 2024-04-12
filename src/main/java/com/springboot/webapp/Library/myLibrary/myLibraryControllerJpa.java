package com.springboot.webapp.Library.myLibrary;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class myLibraryControllerJpa {

	private myLibraryRepository mylibraryrepo;

	// To inject we are using this constructor
	public myLibraryControllerJpa(myLibraryRepository mylibraryrepo) {

		super();
		this.mylibraryrepo = mylibraryrepo;

	}

	@RequestMapping("/library")
	public String listAllBooks(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		List<myLibrary> library = mylibraryrepo.findByUsername(username);
		model.addAttribute("library", library);
		return "library";

	}

	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
	public String showNewBooks(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		myLibrary book = new myLibrary(username, 0, "", "", 0);
		model.put("library", book);
		return "add-book";

	}

	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
	public String addNewBooks(@Valid myLibrary library, BindingResult result, ModelMap model, HttpSession session) {
		model.put("library", library);
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				if (error.getField().equals("totalBooks")) {
					model.put("errorTotal", error.getDefaultMessage());
				} else if (error.getField().equals("authorName")) {
					model.put("errorAuth", error.getDefaultMessage());
				}
			}
			return "add-book";
		}
		String username = (String) model.get("name");
		library.setUsername(username);
		mylibraryrepo.save(library);

		return "redirect:library";
	}

	@RequestMapping("delete-book")
	public String deleteBooks(@RequestParam int bookId, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		mylibraryrepo.deleteById(bookId);
		return "redirect:library";

	}

	@RequestMapping(value = "/update-book", method = RequestMethod.GET)
	public String showToUpdateBooks(@RequestParam int bookId, ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		myLibrary book = mylibraryrepo.findById(bookId).get();
		model.addAttribute("library", book);
		return "update-add-book";

	}

	@RequestMapping(value = "/update-book", method = RequestMethod.POST)
	public String UpdateBooks(@Valid myLibrary library, BindingResult result, ModelMap model, HttpSession session) {
		model.put("library", library);
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				if (error.getField().equals("totalBooks")) {
					model.put("errorTotal", error.getDefaultMessage());
				} else if (error.getField().equals("authorName")) {
					model.put("errorAuth", error.getDefaultMessage());
				}
			}
			return "update-add-book";
		}

		String username = (String) model.get("name");
		library.setUsername(username);
		mylibraryrepo.save(library);
		return "redirect:library";

	}

}
