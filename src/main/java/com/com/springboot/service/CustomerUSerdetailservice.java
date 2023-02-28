package com.com.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.com.springboot.entity.User;
import com.com.springboot.repository.UserRepository;

@Service
public class CustomerUSerdetailservice  implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
	User user=	userRepository.findByUserName(username);
	
	
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList());
	}

}
