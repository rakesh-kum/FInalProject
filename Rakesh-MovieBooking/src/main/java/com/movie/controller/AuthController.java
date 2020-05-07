package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.service.UserService;
import com.movie.utils.AuthenticationRequest;
import com.movie.utils.AuthenticationResponse;
import com.movie.utils.JwtUtil;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AuthController {
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	UserService userDetailsService;

	@Autowired
	JwtUtil jwtutil;
	
	@PostMapping(value="/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try
		{
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch(Exception e)
		{
			throw new Exception("Incorrect UserName Password",e);
		}
		
		final UserDetails userdetails=userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt=jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	
}
