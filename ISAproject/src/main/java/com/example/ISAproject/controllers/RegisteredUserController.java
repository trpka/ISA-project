package com.example.ISAproject.controllers;

import java.util.Optional;

import com.example.ISAproject.model.*;
import com.example.ISAproject.service.DonationTermsService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

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

	@Autowired
	private DonationTermsService donationTermsService;
	
	

	 @RequestMapping(value="api/regUsers/{id}",method = RequestMethod.GET,produces= {
	            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	    public ResponseEntity<RegisteredUser> getById(@PathVariable Long id)
	    {

		 RegisteredUser registeredUser =this.registeredUserService.findById(id);

	        return new ResponseEntity<>(registeredUser,HttpStatus.OK);
	    }


	  @RequestMapping(value="api/regUsers",method = RequestMethod.GET,produces = {
	            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    public ResponseEntity<List<RegisteredUser>> findAll()
	    {
	        List<RegisteredUser> registeredUsers= this.registeredUserService.findAll();
	        return new ResponseEntity<>(registeredUsers, HttpStatus.OK);
	    }


	@RequestMapping(value="api/registeredUsersFirstName", method = RequestMethod.GET,
			params = "firstName",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<RegisteredUser>> findByName(@RequestParam String firstName){
		List<RegisteredUser> registeredUsers=this.registeredUserService.findByFirstName(firstName);
		return new ResponseEntity<>(registeredUsers,HttpStatus.OK);
	}

	@RequestMapping(value="api/registeredUsersLastName", method = RequestMethod.GET,
			params = "lastName",
			produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<RegisteredUser>> findByLastName(@RequestParam String lastName){
		List<RegisteredUser> registeredUsers=this.registeredUserService.findByLastName(lastName);
		return new ResponseEntity<>(registeredUsers,HttpStatus.OK);
	}




	@PutMapping("api/regUsers/edit") 
	@PreAuthorize("hasRole('REGISTERED_USER')")
	public ResponseEntity<RegisteredUser>UpdateRegUser(@RequestBody RegisteredUser reg) { 
		RegisteredUser regUser = this.registeredUserService.UpdateRegUser(reg); 
		return new ResponseEntity<>(regUser, HttpStatus.OK);
		}


	//Pretraga Termina prema korisniku za kojeg je zakazano
	@RequestMapping(value="api/users/terms/{id}",method = RequestMethod.GET,produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<List<DonationTerms>> findAllTermsByUser(@PathVariable Long id)

	{
		List<DonationTerms> terms=this.donationTermsService.findAllTermsByUser(id);
		return new ResponseEntity<>(terms,HttpStatus.OK);
    
  }



	@RequestMapping(value="/api/confirm-registration-register-user/{id}",method = RequestMethod.GET,produces=
			MediaType.APPLICATION_JSON_VALUE)
	public void confirmRegistrationForRegisteredUser(@PathVariable Long id) {
		//this.clientService.activateById(id);
		this.registeredUserService.save(this.registeredUserService.activateById(id));

	}

}
