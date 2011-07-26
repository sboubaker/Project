package org.groupid.project.dao;

import java.util.List;

import org.groupid.project.model.Book;



public interface BookDao {

	Book get(Long id);
	void save(Book user);
	void delete(Book user);
	List<Book> findAll();

}
