package com.movie.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.ICustomerDao;
import com.movie.dao.IUniversalDao;
import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;
@Service
public class MovieService implements Imovieservice {
	@Autowired
	ICustomerDao customerdao;

	@Autowired
	IUniversalDao<Customer> dao;
	

	@Override
	public String getContact(Integer userid) {
		// TODO Auto-generated method stub
		return customerdao.getContact(userid);
	}

	@Override
	public Customer getCustomer(Integer userid) {
		// TODO Auto-generated method stub
		return dao.findById(userid);
	}

	

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.save(customer);
		return customer;
	}

	@Override
	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		dao.remove(customer);
		
	}

	@Override
	public void removeCustomer(Integer userId) {
		// TODO Auto-generated method stub
		dao.remove(userId);
		
	}

	@Override
	public List<Theatre> chooseCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theatre addTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		return null;
	}



}
