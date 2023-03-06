package com.keval.SpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.dao.UserDao;
import com.keval.SpringSecurity.model.User;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDaoImpl;
	
	public List<User> getUsers() {
		return userDaoImpl.getUsers();
	}

	
	public User getUser(int userId) {
		return userDaoImpl.getUser(userId);
	}

	public void createUser(User user) {
		userDaoImpl.createUser(user);
	}

	public void updateUser(User user) {
		userDaoImpl.updateUser(user);
	}

	public void deleteUser(int userId) {
		userDaoImpl.deleteUser(userId);
	}
}
