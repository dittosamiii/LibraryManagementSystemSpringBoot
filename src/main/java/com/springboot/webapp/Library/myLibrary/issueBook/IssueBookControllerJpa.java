package com.springboot.webapp.Library.myLibrary.issueBook;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.webapp.Library.myLibrary.MyLibrary;
import com.springboot.webapp.Library.myLibrary.MyLibraryRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class IssueBookControllerJpa {

	private IssueBookRepository issueBookRepo;
	private MyLibraryRepository myLibraryRepo;

	// To inject we are using this constructor
	public IssueBookControllerJpa(IssueBookRepository issueBookRepo, MyLibraryRepository mylibraryrepo) {

		super();
		this.issueBookRepo = issueBookRepo;
		this.myLibraryRepo = mylibraryrepo;

	}

	@RequestMapping("/issue")
	public String issueBooksPage(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		List<IssueBooks> issueBooks = issueBookRepo.findByUsername(username);
		model.addAttribute("issueBook", issueBooks);
		return "issue";

	}

	@RequestMapping(value = "/issue-book", method = RequestMethod.GET)
	public String issuingBooks(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		String username = (String) model.get("name");
		IssueBooks book = new IssueBooks(0, username, 0, 0, "", "", LocalDate.now(), LocalDate.now());
		model.put("issueBook", book);
		return "issue-book";

	}

	@RequestMapping(value = "/issue-book", method = RequestMethod.POST)
	public String returnissueBooks(@RequestParam int bookId, @Valid IssueBooks book, BindingResult result,
			ModelMap model, HttpSession session) {
		model.put("issueBook", book);
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				if (error.getField().equals("studentId")) {
					model.put("error", error.getDefaultMessage());
				} else if (error.getField().equals("studentName")) {
					model.put("errorStud", error.getDefaultMessage());
				}
			}
			return "issue-book";
		}

		String username = (String) model.get("name");
		book.setUsername(username);

		MyLibrary currBook = myLibraryRepo.findById(bookId).get();
		if (currBook.getTotalBooks() == 0) {
			model.put("errorMessage", "Book not available");
			return "issue-book";
		}
		LocalDate today = LocalDate.now();
		// Return Date Logic where return date is not before the issue date
		// Check if issueDate is before returnDate
		if (book.getIssueDate().isEqual(today)) {
			if (book.getIssueDate().isBefore(book.getReturnDate())) {

				// Book Issue Logic for decreasing the quantity of the book
				MyLibrary libraryBook = myLibraryRepo.findById(bookId).get();
				libraryBook.setTotalBooks(libraryBook.getTotalBooks() - 1);
				myLibraryRepo.save(libraryBook);
				String name = libraryBook.getBookName();
				book.setBookName(name);

				issueBookRepo.save(book);
				return "redirect:issue";
			} else {
				model.put("errorMessage", "Invalid Return Date!");
				return "issue-book";
			}
		} else {
			model.put("errorMessage1", "Invalid Issue Date!");
			return "issue-book";
		}

	}

	@RequestMapping(value = "/update-issue-book", method = RequestMethod.GET)
	public String showToUpdateBooks(@RequestParam int sequence, HttpSession session, ModelMap model) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		IssueBooks book = issueBookRepo.findById(sequence).get();
		model.addAttribute("issueBook", book);
		return "issue-book";

	}

	@RequestMapping(value = "/update-issue-book", method = RequestMethod.POST)
	public String UpdateBooks(@Valid IssueBooks book, BindingResult result, ModelMap model, HttpSession session) {
		model.put("issueBook", book);
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		
		if (result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				if (error.getField().equals("studentId")) {
					model.put("error", error.getDefaultMessage());
				} else if (error.getField().equals("studentName")) {
					model.put("errorStud", error.getDefaultMessage());
				}
			}
			return "issue-book";
		}

		String username = (String) model.get("name");
		book.setUsername(username);
		LocalDate today = LocalDate.now();
		// Check if issueDate is before returnDate
		if (book.getIssueDate().isEqual(today)) {
			if (book.getIssueDate().isBefore(book.getReturnDate())) {
				issueBookRepo.save(book);
				return "redirect:issue";
			} else {
				model.put("errorMessage", "Invalid Return Date!");
				return "issue-book";
			}
		} else {
			model.put("errorMessage1", "Invalid Issue Date!");
			return "issue-book";
		}
	}

}
