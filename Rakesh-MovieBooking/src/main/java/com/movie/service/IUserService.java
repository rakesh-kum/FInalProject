package com.movie.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.movie.entities.Customer;
import com.movie.entities.User;
@Service
public interface IUserService extends UserDetailsService {

	public User findById(Integer id);
	
}
