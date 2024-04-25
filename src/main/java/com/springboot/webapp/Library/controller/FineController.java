package com.springboot.webapp.Library.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.webapp.Library.entity.Fine;
import com.springboot.webapp.Library.entity.IssueBooks;
import com.springboot.webapp.Library.entity.MyLibrary;
import com.springboot.webapp.Library.repository.FineRepository;
import com.springboot.webapp.Library.repository.IssueBookRepository;
import com.springboot.webapp.Library.repository.MyLibraryRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class FineController {

	private FineRepository fineRepo;
	private IssueBookRepository issueBookRepo;
	private MyLibraryRepository myLibraryRepo;

	// To inject we are using this constructor
	public FineController(FineRepository finerepo, IssueBookRepository issuebookrepo,
			MyLibraryRepository mylibraryrepo) {

		super();
		this.fineRepo = finerepo;
		this.issueBookRepo = issuebookrepo;
		this.myLibraryRepo = mylibraryrepo;

	}

	@GetMapping("/fine")
	public String listAllBooks(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		List<Fine> fine = fineRepo.findByUsername(username);
		model.addAttribute("fine", fine);
		return "fine";

	}

	@GetMapping("/return")
	public String showReturnPage(@RequestParam int sequence, ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		Fine fineBook = new Fine(0, username, 0, 0, LocalDate.now(), LocalDate.now(), LocalDate.now(), 0);
		model.put("fine", fineBook);

		IssueBooks issueBook = issueBookRepo.findById(sequence).get();
		fineBook.setIssueDate(issueBook.getIssueDate());
		fineBook.setReturnDate(issueBook.getReturnDate());
		model.addAttribute("fine", fineBook);
		return "return";

	}

	@PostMapping("/return")
	public String processReturnPage(@RequestParam int sequence, @Valid Fine book, BindingResult result, ModelMap model,
			HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}

		if (result.hasErrors()) {
			model.put("fine", book);
			return "return";
		}

		String username = (String) model.get("name");
		book.setUsername(username);

		IssueBooks issueBook = issueBookRepo.findById(sequence).get();
		book.setBookId(issueBook.getBookId());
		book.setStudentId(issueBook.getStudentId());

		if (!book.getReturnedDate().isBefore(book.getIssueDate())) {
			// Return Book Logic which returns the book back to the library by increasing
			// value of the available book
			IssueBooks issuedBook = issueBookRepo.findById(sequence).get();

			Optional<MyLibrary> optionalBook = myLibraryRepo.findById(issuedBook.getBookId());

			if (optionalBook.isPresent()) {

				MyLibrary libraryBook = myLibraryRepo.findById(issuedBook.getBookId()).get();
				libraryBook.setTotalBooks(libraryBook.getTotalBooks() + 1);

				myLibraryRepo.save(libraryBook);
			}
			issueBookRepo.delete(issuedBook);

			if (book.getReturnedDate().isBefore(book.getReturnDate())
					|| book.getReturnDate().isEqual(book.getReturnedDate())) {
				return "redirect:library";
			} else {
				LocalDate returnDate = book.getReturnDate();
				LocalDate returnedDate = book.getReturnedDate();
				int daysBetween = (int) ChronoUnit.DAYS.between(returnDate, returnedDate);
				int paidAmount = daysBetween * 50;
				book.setAmount(paidAmount);
				fineRepo.save(book);
			}
			return "redirect:fine";
		} else {
			model.put("errorMessage", "Invalid Return Date!");
			return "return";
		}
	}
}
