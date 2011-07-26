package org.groupid.project.service;

import java.util.List;

import org.groupid.project.model.Book;


public interface BookService {
	
	Book get(Long id);
	void save(Book book);
	void delete(Book book);
	List<Book> findAll();
	void saveAll(List<Book> books);
	
}
