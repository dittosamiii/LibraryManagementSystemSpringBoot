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

import com.springboot.webapp.Library.myLibrary.myLibrary;
import com.springboot.webapp.Library.myLibrary.myLibraryRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class issueBookControllerJpa {

	private issueBookRepository issueBookRepo;
	private myLibraryRepository myLibraryRepo;

	// To inject we are using this constructor
	public issueBookControllerJpa(issueBookRepository issueBookRepo, myLibraryRepository mylibraryrepo) {

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
		issueBooks book = new issueBooks(0, username, 0, 0, "", "", LocalDate.now(), LocalDate.now());
		model.put("issueBook", book);
		return "issue-book";

	}

	@RequestMapping(value = "/issue-book", method = RequestMethod.POST)
	public String returnissueBooks(@RequestParam int bookId, @Valid issueBooks book, BindingResult result,
			ModelMap model, HttpSession session) {
		model.put("issueBook", book); // Always add 'issueBook' to the model

		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		if (result.hasErrors()) {
			model.put("issueBook", book);
			return "issue-book";
		}
		String username = (String) model.get("name");
		book.setUsername(username);

		// Return Date Logic where return date is not before the issue date
		// Check if issueDate is before returnDate
		if (book.getIssueDate().isBefore(book.getReturnDate())) {

			// Book Issue Logic for decreasing the quantity of the book
			myLibrary libraryBook = myLibraryRepo.findById(bookId).get();
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
	}

	@RequestMapping(value = "/update-issue-book", method = RequestMethod.GET)
	public String showToUpdateBooks(@RequestParam int sequence, HttpSession session, ModelMap model) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		issueBooks book = issueBookRepo.findById(sequence).get();
		model.addAttribute("issueBook", book);
		return "issue-book";

	}

	@RequestMapping(value = "/update-issue-book", method = RequestMethod.POST)
	public String UpdateBooks(@Valid issueBooks book, BindingResult result, ModelMap model, HttpSession session) {
		model.put("issueBook", book); // Always add 'issueBook' to the model

		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		if (result.hasErrors()) {
			return "issue-book";
		}

		String username = (String) model.get("name");
		book.setUsername(username);

		// Check if issueDate is before returnDate
		if (book.getIssueDate().isBefore(book.getReturnDate())) {
			issueBookRepo.save(book);
			return "redirect:issue";
		} else {
			model.put("errorMessage", "Invalid Return Date!");
			return "issue-book";
		}
	}

	@RequestMapping(value = "/return-issue-book")
	public String returnBooks(@RequestParam int sequence, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		// Return Book Logic which returns the book back to the library by increasing
		// value of the available book
		issueBooks issuedBook = issueBookRepo.findById(sequence).get();
		myLibrary libraryBook = myLibraryRepo.findById(issuedBook.getBookId()).get();
		libraryBook.setTotalBooks(libraryBook.getTotalBooks() + 1);

		myLibraryRepo.save(libraryBook);
		issueBookRepo.delete(issuedBook);

		return "redirect:issue";

	}
}
