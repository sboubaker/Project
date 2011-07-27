package org.groupid.project.web;

import javax.validation.Valid;

import org.groupid.project.model.Book;
import org.groupid.project.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(BookController.URL)
public class BookController {

	static final String URL = "/biblio";
	static final String BOOK_TILES = "book-tiles";
	static final String BOOKS_TILES = "books-tiles";
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired private BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("books",bookService.findAll());
		return BOOKS_TILES;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/book")
	public String newBook(Model model) {
		model.addAttribute("emptybook",new Book());
		return BOOK_TILES;
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/books")
	public String fetchBooks(Model model) {
		model.addAttribute("books",bookService.findAll());
		return BOOKS_TILES;
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/book")
	public String post(Model model, @Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			logger.info("Validation failed");
			model.addAttribute("emptybook",new Book());
			return BOOK_TILES;
		}
		bookService.save(book);
		return "redirect:" ;
	}
}
