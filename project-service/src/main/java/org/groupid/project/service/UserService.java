package org.groupid.project.service;

import java.util.List;

import org.groupid.project.model.User;


public interface UserService {
	

	void save(User user);
	List<User> findAll();

	
}
