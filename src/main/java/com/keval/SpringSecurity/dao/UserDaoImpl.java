package com.keval.SpringSecurity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.model.User;

@Component
public class UserDaoImpl implements UserDao {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers() {		
		return userRepository.findAll();
	}

	public User getUser(int userId) {
		return userRepository.findById(userId).get();
	}

	public void createUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}
}
