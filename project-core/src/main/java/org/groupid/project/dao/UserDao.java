package org.groupid.project.dao;

import java.util.List;

import org.groupid.project.model.User;



public interface UserDao {

	User getByEmail(String email);
	void save(User user);
	List<User> findAll();

}
