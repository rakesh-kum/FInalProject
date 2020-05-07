package com.movie.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie.dao.IUserDao;
import com.movie.dao.UserDao;
import com.movie.entities.Customer;
import com.movie.entities.User;
import com.movie.entities.UserType;
@Service
public class UserService implements UserDetailsService,IUserService {
	@Autowired
	IUserDao dao;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=dao.getUserByName(username);
		return new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return user.getIsActive();
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return user.getUsername();
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return user.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return new ArrayList<>();
			}
		};
}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		User user=dao.findById(id);
		return user;
	}
}