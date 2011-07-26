package org.groupid.project.dao.impl;

import java.util.List;

import org.groupid.project.dao.BookDao;
import org.groupid.project.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;

	public Book get(Long id) {
		return (Book) sessionFactory.getCurrentSession()
			.createQuery("from Book book where book.id = :id")
			.setLong("id", id).uniqueResult();
	}

	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	public void save(Book user) {
		sessionFactory.getCurrentSession().merge(user);
		
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
