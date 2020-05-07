package com.movie.dao;

import com.movie.entities.Customer;
import com.movie.entities.User;

public interface IUserDao {

	public User getUserByName(String username);
	
	public User findById(Integer id);
	
	public Boolean isUserNameExists(String username);
	
}
