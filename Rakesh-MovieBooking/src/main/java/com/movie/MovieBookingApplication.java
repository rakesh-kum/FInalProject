package com.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movie.entities.Customer;
import com.movie.entities.Theatre;
import com.movie.service.Imovieservice;
import com.movie.service.MovieService;

@SpringBootApplication
public class MovieBookingApplication implements CommandLineRunner {
	
	@Autowired
	Imovieservice service;

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Rakesh started successfully");
	}

}
