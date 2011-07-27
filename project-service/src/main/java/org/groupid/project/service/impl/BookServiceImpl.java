package org.groupid.project.service.impl;

import java.util.List;

import org.groupid.project.dao.BookDao;
import org.groupid.project.model.Book;
import org.groupid.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired(required=true)
	private BookDao bookDao;
	
	@Transactional(readOnly=true)
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}
}
