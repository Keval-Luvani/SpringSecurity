package com.keval.SpringSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.keval.SpringSecurity.model.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
	public User getByEmail(String email);
}
