package com.example.ISAproject.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.service.RegisteredUserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin("*")
@RestController
public class RegisteredUserController {



	@Autowired
	private RegisteredUserService registeredUserService;
	
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


	@RequestMapping(value="api/registeredUsers", method = RequestMethod.GET,
			params = "name",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<RegisteredUser>> findByName(@RequestParam String name){
		List<RegisteredUser> registeredUsers=this.registeredUserService.findByFirstName(name);
		return new ResponseEntity<>(registeredUsers,HttpStatus.OK);
	}

}
