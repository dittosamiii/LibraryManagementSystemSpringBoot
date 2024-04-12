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

import com.springboot.webapp.Library.myLibrary.myLibrary;
import com.springboot.webapp.Library.myLibrary.myLibraryRepository;
import com.springboot.webapp.Library.myLibrary.issueBook.issueBookRepository;
import com.springboot.webapp.Library.myLibrary.issueBook.issueBooks;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class fineControllerJpa {

	private fineRepository fineRepo;
	private issueBookRepository issueBookRepo;
	private myLibraryRepository myLibraryRepo;

	// To inject we are using this constructor
	public fineControllerJpa(fineRepository finerepo, issueBookRepository issuebookrepo,
			myLibraryRepository mylibraryrepo) {

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
		List<fine> fine = fineRepo.findByUsername(username);
		model.addAttribute("fine", fine);
		return "fine";

	}

	@RequestMapping(value = "/return", method = RequestMethod.GET)
	public String showReturnPage(@RequestParam int sequence, ModelMap model, HttpSession session) {
		if (session.getAttribute("loggedInUser") == null) {
			return "redirect:login";
		}
		String username = (String) model.get("name");
		fine fineBook = new fine(0, username, 0, 0, LocalDate.now(), LocalDate.now(), LocalDate.now(), 0);
		model.put("fine", fineBook);

		issueBooks issueBook = issueBookRepo.findById(sequence).get();
		fineBook.setIssueDate(issueBook.getIssueDate());
		fineBook.setReturnDate(issueBook.getReturnDate());
		model.addAttribute("fine", fineBook);
		return "return";

	}

	@RequestMapping(value = "/return", method = RequestMethod.POST)
	public String processReturnPage(@RequestParam int sequence, @Valid fine book, BindingResult result, ModelMap model,
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

		issueBooks issueBook = issueBookRepo.findById(sequence).get();
		book.setBookId(issueBook.getBookId());
		book.setStudentId(issueBook.getStudentId());

		if (!book.getReturnedDate().isBefore(book.getIssueDate())) {
			// Return Book Logic which returns the book back to the library by increasing
			// value of the available book
			issueBooks issuedBook = issueBookRepo.findById(sequence).get();
			myLibrary libraryBook = myLibraryRepo.findById(issuedBook.getBookId()).get();
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
