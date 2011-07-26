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
	public Book get(Long id) {
		return bookDao.get(id);
	}

	@Transactional
	public void delete(Book book) {
		bookDao.delete(book);
	}

	@Transactional(readOnly=true)
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}

	@Transactional
	public void saveAll(List<Book> books) {
		for (Book book : books)
			bookDao.save(book);
	}
	
}
