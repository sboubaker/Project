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



	@SuppressWarnings("unchecked")
	public List<Book> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	public void save(Book book) {
		sessionFactory.getCurrentSession().merge(book);
		
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
