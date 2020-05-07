package com.movie.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.movie.entities.Customer;
import com.movie.entities.User;

@Repository
@Transactional
public class UserDao implements IUserDao,IUniversalDao<User>{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from User user where username='"+username+"'");
		User u=(User) q.getSingleResult();
		return u;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public void save(User entityObject) {
		// TODO Auto-generated method stub
		em.persist(entityObject);
	}

	@Override
	public User remove(Integer id) {
		// TODO Auto-generated method stub
		User user=findById(id);
		em.remove(user);
		return user;
	}

	@Override
	public User remove(User entityObject) {
		// TODO Auto-generated method stub
		User user=findById(entityObject.getUserId());
		em.remove(entityObject);
		return user; 
	}

	@Override
	public User update(Integer id, User entityObject) {
		// TODO Auto-generated method stub
		entityObject.setUserId(id);
		User user=findById(id);
		return em.merge(entityObject);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("from User user");
		return q.getResultList();
	}

	@Override
	public User update(User entityObject) {
		// TODO Auto-generated method stub
		return em.merge(entityObject);
	}

	@Override
	public Boolean isUserNameExists(String username) {
		// TODO Auto-generated method stub
		
		Query q=em.createQuery("from User user where username='"+username+"'");
		if(q.getSingleResult().equals(null))
		{
			return false;
		}
		return true;
	}

	
	
}
