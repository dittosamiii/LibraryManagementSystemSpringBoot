//package com.springboot.webapp.Library.myLibrary;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//
////@Controller
//@SessionAttributes("name")
//public class myLibraryController {
//
//	private myLibraryService libraryService;
//
//	// To inject we are using this constructor
//	public myLibraryController(myLibraryService libraryService) {
//
//		super();
//		this.libraryService = libraryService;
//
//	}
//
//	@RequestMapping("/library")
//	public String getBooks(ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		List<myLibrary> library = libraryService.getBooks();
//		model.put("library", library);
//		return "library";
//
//	}
//
//	@RequestMapping(value = "/add-book", method = RequestMethod.GET)
//	public String addBooks(ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		myLibrary book = new myLibrary(0, "", "", 0, true);
//		model.put("library", book);
//		return "add-book";
//
//	}
//
//	@RequestMapping(value = "/add-book", method = RequestMethod.POST)
//	public String returnToBooks(@Valid myLibrary library, BindingResult result, ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		if (result.hasErrors()) {
//			model.put("library", library);
//			return "add-book";
//		}
//		libraryService.addBook(library.getBookId(), library.getBookName(), library.getAuthorName(), library.getPrice(),
//				true);
//		return "redirect:library";
//
//	}
//
//	@RequestMapping("delete-book")
//	public String deleteBooks(@RequestParam int bookId, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//
//		libraryService.deleteBookById(bookId);
//		return "redirect:library";
//
//	}
//
//	@RequestMapping(value = "/update-book", method = RequestMethod.GET)
//	public String showToUpdateBooks(@RequestParam int bookId, ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//
//		myLibrary book = libraryService.findById(bookId);
//		model.addAttribute("library", book);
//		return "add-book";
//
//	}
//
//	@RequestMapping(value = "/update-book", method = RequestMethod.POST)
//	public String UpdateBooks(@Valid myLibrary library, BindingResult result, ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//
//		if (result.hasErrors()) {
//			model.put("library", library);
//			return "add-book";
//		}
//		libraryService.updateBooks(library);
//		return "redirect:library";
//
//	}
//
//}
