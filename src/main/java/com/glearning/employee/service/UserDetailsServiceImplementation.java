package com.glearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.glearning.employee.entity.User;
import com.glearning.employee.repository.model.UserRepository;
import com.glearning.employee.security.config.MyUserDetails;

public class UserDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, NullPointerException, ArrayIndexOutOfBoundsException {
		User user = userRepository.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Record Not Found .");
		}
		return new MyUserDetails(user);
	}

}
