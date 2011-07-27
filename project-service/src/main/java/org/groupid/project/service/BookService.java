package org.groupid.project.service;

import java.util.List;

import org.groupid.project.model.Book;


public interface BookService {
	

	void save(Book book);
	List<Book> findAll();

	
}
