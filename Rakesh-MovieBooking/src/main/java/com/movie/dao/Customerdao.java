package com.movie.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.movie.entities.Booking;
import com.movie.entities.Customer;
import com.movie.entities.Theatre;
import com.movie.entities.Ticket;
@Repository
@Transactional
public class Customerdao implements ICustomerDao,IUniversalDao<Customer> {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public void save(Customer entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
		
	}

	@Override
	public Customer findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, id);
	}

	@Override
	public Customer remove(Integer id) throws EntityNotFoundException{
		// TODO Auto-generated method stub
		Customer customer=findById(id);
		if(customer==null)
		{
			throw new EntityNotFoundException("Customer with "+id+" is not found to delete");
		}
		em.remove(customer);
		return customer;
	}

	@Override
	public Customer remove(Customer entityObject) throws EntityNotFoundException{
		// TODO Auto-generated method stub
		Customer customer=findById(entityObject.getUserId());
		if(customer==null)
		{
			throw new EntityNotFoundException("Customer with "+entityObject.getUserId()+" is not found to delete");
		}
		em.remove(customer);
		return customer;
	}

	@Override
	public Customer update(Integer id, Customer entityObject) throws EntityNotFoundException{
		// TODO Auto-generated method stub
		Customer customer=findById(id);
		if(customer==null)
		{
			throw new EntityNotFoundException("Customer with "+id+" is not found to update");
		}
		return em.merge(entityObject);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from Customer c");
		return q.getResultList();
	}

	@Override
	public Customer update(Customer entityObject) {
		// TODO Auto-generated method stub
		Customer customer=findById(entityObject.getUserId());
		if(customer==null)
		{
			throw new EntityNotFoundException("Customer with "+entityObject.getUserId()+" is not found to delete");
		}

		return em.merge(entityObject);
	}

	@Override
	public String getContact(Integer userid) throws EntityNotFoundException{
		// TODO Auto-generated method stub
		if(findById(userid)==null)
		{
			throw new EntityNotFoundException("The User is not found");
		}
		return findById(userid).getContact();
	}

	@Override
	public void updateContact(Integer userid, String contact) {
		// TODO Auto-generated method stub
		if(findById(userid)==null)
		{
			throw new EntityNotFoundException("The User is not found");
		}
		Customer c=findById(userid);
		c.setContact(contact);
		em.merge(c);
	}

	@Override
	public Set<Booking> getMyBookings(Integer Id) {
		// TODO Auto-generated method stub
		
		return findById(Id).getBookings();
	}

	@Override
	public Set<Booking> getMyBookings(Customer customer) {
		// TODO Auto-generated method stub
		return findById(customer.getUserId()).getBookings();
	}

	@Override
	public Set<Ticket> getMyTickets(Integer id) {
		// TODO Auto-generated method stub
		return findById(id).getTicket();
	}

	@Override
	public Set<Ticket> getMyTickets(Customer customer) {
		// TODO Auto-generated method stub
		return findById(customer.getUserId()).getTicket();
	}

	
	
	
	


}
