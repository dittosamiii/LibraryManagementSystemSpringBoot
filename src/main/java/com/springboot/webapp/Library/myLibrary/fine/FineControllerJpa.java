package com.springboot.webapp.Library.myLibrary.fine;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.webapp.Library.myLibrary.MyLibrary;
import com.springboot.webapp.Library.myLibrary.MyLibraryRepository;
import com.springboot.webapp.Library.myLibrary.issueBook.IssueBookRepository;
import com.springboot.webapp.Library.myLibrary.issueBook.IssueBooks;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class FineControllerJpa {

	private FineRepository fineRepo;
	private IssueBookRepository issueBookRepo;
	private MyLibraryRepository myLibraryRepo;

	// To inject we are using this constructor
	public FineControllerJpa(FineRepository finerepo, IssueBookRepository issuebookrepo,
			MyLibraryRepository mylibraryrepo) {

		super();
		this.fineRepo = finerepo;
		this.issueBookRepo = issuebookrepo;
		this.myLibraryRepo = mylibraryrepo;

	}

	@RequestMapping("/fine")
	public String listAllBooks(ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		List<Fine> fine = fineRepo.findByUsername(username);
		model.addAttribute("fine", fine);
		return "fine";

	}

	@RequestMapping(value = "/return", method = RequestMethod.GET)
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

	@RequestMapping(value = "/return", method = RequestMethod.POST)
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
			MyLibrary libraryBook = myLibraryRepo.findById(issuedBook.getBookId()).get();
			libraryBook.setTotalBooks(libraryBook.getTotalBooks() + 1);

			myLibraryRepo.save(libraryBook);
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
			model.put("errorMessage", "Invalid Returned Date!");
			return "return";
		}
	}
}
