//package com.springboot.webapp.Library.myLibrary.issueBook;
//
//import java.time.LocalDate;
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
//@Controller
//@SessionAttributes("name")
//public class issueBookController {
//
//	private issueBookService issuebookservice;
//
//	// To inject we are using this constructor
//	public issueBookController(issueBookService issuebookservice) {
//
//		super();
//		this.issuebookservice = issuebookservice;
//	}
//
//	@RequestMapping("issue")
//	public String issueBooksPage(ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		List<issueBooks> issueBooks = issuebookservice.getBooks();
//		model.put("issueBook", issueBooks);
//		return "issue";
//
//	}
//
//	@RequestMapping(value = "/issue-book", method = RequestMethod.GET)
//	public String issuingBooks(ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		issueBooks book = new issueBooks(0, 0, "", "", LocalDate.now(), LocalDate.now());
//		model.put("issueBook", book);
//		return "issue-book";
//
//	}
//
//	@RequestMapping(value = "/issue-book", method = RequestMethod.POST)
//	public String returnissueBooks(@Valid issueBooks book, BindingResult result, ModelMap model, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		if (result.hasErrors()) {
//			model.put("issueBook", book);
//			return "issue-book";
//		}
//		issuebookservice.issueBook(book.getBookId(), book.getStudentId(), book.getStudentName(), book.getBookName(),
//				LocalDate.now(), LocalDate.now().plusDays(10));
//
//		return "redirect:issue";
//
//	}
//
//	@RequestMapping(value = "/delete-issue-book")
//	public String deleteBooks(@RequestParam int bookId, HttpSession session) {
//		if (session.getAttribute("loggedInUser") == null) {
//			return "redirect:login";
//		}
//		issuebookservice.deleteBookById(bookId);
//		return "redirect:issue";
//
//	}
//
//}
