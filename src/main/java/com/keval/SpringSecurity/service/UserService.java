package com.keval.SpringSecurity.service;

import java.util.List;

import com.keval.SpringSecurity.model.User;

public interface UserService {
	public List<User> getUsers();
	public User getUser(int userId);
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userId);
}
