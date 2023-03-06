package com.keval.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.keval.SpringSecurity.dao.UserRepository;
import com.keval.SpringSecurity.model.User;
import com.keval.SpringSecurity.model.UserDetailImpl;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepository.getByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("NO USER");
		}
		return new UserDetailImpl(user);
	}

}
