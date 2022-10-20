package com.example.ISAproject.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.ISAproject.dto.AuthenticatedUserDTO;
import com.example.ISAproject.dto.UserDTO;
import com.example.ISAproject.dto.UserTokenState;
import com.example.ISAproject.exception.ResourceConflictException;
import com.example.ISAproject.model.User;
import com.example.ISAproject.security.auth.JwtAuthenticationRequest;
import com.example.ISAproject.service.UserService;
import com.example.ISAproject.util.TokenUtils;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {

		 AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
	        User u = userService.findByUsername(authenticationRequest.getUsername());
	      
	        if(u!=null){
	           
	                Authentication authentication = authenticationManager
	                        .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
	                                authenticationRequest.getPassword()));

	                SecurityContext ctx = SecurityContextHolder.createEmptyContext();
	                SecurityContextHolder.setContext(ctx);
	                SecurityContextHolder.getContext().setAuthentication(authentication);

	                User user = (User) authentication.getPrincipal();
	                String jwt = tokenUtils.generateToken(user.getUsername());
	                int expiresIn = tokenUtils.getExpiredIn();
	                authenticatedUserDTO = new AuthenticatedUserDTO(user.getId(), user.getRole(), user.getUsername(), new UserTokenState(jwt, expiresIn));
	                return new ResponseEntity<>(authenticatedUserDTO, HttpStatus.OK);}
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserDTO userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		User user = this.userService.save(userRequest);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}/*
	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser1(@RequestBody User userRequest, UriComponentsBuilder ucBuilder) {

		User existUser = this.userService.findByUsername(userRequest.getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		User user = this.userService.save(userRequest);

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}*/
}

