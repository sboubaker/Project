package org.groupid.project.service.impl;

import java.util.List;

import org.groupid.project.dao.UserDao;
import org.groupid.project.model.User;
import org.groupid.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	
	@Autowired(required=true)
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Transactional
	public void save(User user) {
		userDao.save(user);
	}
	@Transactional
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException, DataAccessException {
		return userDao.getByEmail(email);
	}
}
