package org.groupid.project.dao;

import java.util.List;

import org.groupid.project.model.Book;



public interface BookDao {

	
	void save(Book book);
	List<Book> findAll();

}
