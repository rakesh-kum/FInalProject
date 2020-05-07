package com.movie.dao;

import java.util.List;
import java.util.Set;

import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;

public interface ICustomerDao {
	
	public String getContact(Integer userid);
	
	public void updateContact(Integer userid,String contact);
	
	public Set<Booking> getMyBookings(Integer Id);
	
	public Set<Booking> getMyBookings(Customer customer);
	
	public Set<Ticket> getMyTickets(Integer id);
	
	public Set<Ticket> getMyTickets(Customer customer);
	
	
	
	


}
