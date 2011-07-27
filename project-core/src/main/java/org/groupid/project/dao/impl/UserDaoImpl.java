package org.groupid.project.dao.impl;

import java.util.List;

import org.groupid.project.dao.UserDao;
import org.groupid.project.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public void save(User user) {
		sessionFactory.getCurrentSession().merge(user);
		
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getByEmail(String email) {
		return (User)sessionFactory.getCurrentSession().createQuery("from User user where email like :email")
		.setString("email", email).list().get(0);
	}

}
