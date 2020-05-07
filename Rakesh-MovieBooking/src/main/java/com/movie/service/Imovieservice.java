package com.movie.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;

@Service
public interface Imovieservice {
	
	public String getContact(Integer userid);
	
	public Customer getCustomer(Integer userid);
	
	public Customer addCustomer(Customer customer);
	
	public void removeCustomer(Customer customer);
	
	public void removeCustomer(Integer userId);
	
	public List<Theatre> chooseCity(String city);
	
	public Theatre addTheatre(Theatre theatre);
	

}
