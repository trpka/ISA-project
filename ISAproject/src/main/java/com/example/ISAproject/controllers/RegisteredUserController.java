package com.example.ISAproject.controllers;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ISAproject.model.Authority;
import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.service.AuthorityService;
import com.example.ISAproject.service.RegisteredUserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@CrossOrigin("*")
@RestController
public class RegisteredUserController {



	@Autowired
	private RegisteredUserService registeredUserService;
	
	@Autowired
	private AuthorityService authorityService;
	
	@RequestMapping(value="api/regUser/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisteredUser> getById(@PathVariable Long id){
		Optional<RegisteredUser> item= registeredUserService.findById(id); 
		
		if(!item.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		RegisteredUser itemDto=new RegisteredUser();
		return new ResponseEntity<>(itemDto,HttpStatus.OK);
	}


	  @RequestMapping(value="api/registeredUsers",method = RequestMethod.GET,produces = {
	            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    public ResponseEntity<List<RegisteredUser>> findAll()
	    {
	        List<RegisteredUser> registeredUsers= this.registeredUserService.findAll();
	        return new ResponseEntity<>(registeredUsers, HttpStatus.OK);
	    }

		
		
		/*
		 * @RequestMapping(value="api/regUsers/{id}",method = RequestMethod.PUT,
		 * consumes=MediaType.APPLICATION_JSON_VALUE)
		 * 
		 * @PreAuthorize("hasRole('RegisteredUser')") public
		 * ResponseEntity<RegisteredUser> update(@RequestBody RegisteredUser
		 * regUser,@PathVariable Long id){
		 * 
		 * RegisteredUser updatedRegUser=this.registeredUserService.update(regUser);
		 * 
		 * return new ResponseEntity<>(updatedRegUser,HttpStatus.OK); }
		 */
		 
		 
	 
		
		  @PutMapping("api/updateRegUser") public ResponseEntity<RegisteredUser>
		  UpdateRegUser(@RequestBody RegisteredUser reg) { RegisteredUser regUser =
		  this.registeredUserService.UpdateRegUser(reg); return new
		  ResponseEntity<>(regUser, HttpStatus.OK); }
		 
	  
	 

	  
}
