package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Customer;
import com.movie.entities.Theatre;
import com.movie.service.Imovieservice;



@CrossOrigin(origins="http://localhost:4200")
@RestController
public class MovieController {
	@Autowired
	Imovieservice service;

	@GetMapping(value="/search/{name}")
	@ResponseBody
    public List<Theatre> searchMovie(@PathVariable String name)
    {
    	return service.chooseCity(name);
    }
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id)
	{
		service.removeCustomer(id);;
		return new ResponseEntity<>("Deleted",HttpStatus.NO_CONTENT);
	}
	@GetMapping("/view/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") int id)
	{
		Customer cust=service.getCustomer(id);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
