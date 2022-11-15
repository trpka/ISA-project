package com.example.ISAproject.service;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.RegisteredUserRepository;

@Service
public class RegisteredUserService {

	 @Autowired
	    private RegisteredUserRepository registeredUserRepository;
	 
	 public Optional<RegisteredUser> findById(Long id) {
			return this.registeredUserRepository.findById(id);
		}
	 
     public RegisteredUser save(RegisteredUser newRegUser) {
			return this.registeredUserRepository.save(newRegUser);
		}
    

     public List<RegisteredUser> findAll() { return this.registeredUserRepository.findAll();}

	 public List<RegisteredUser> findByFirstName(String name) {return this.registeredUserRepository.findByFirstName(name);}

	 public List<RegisteredUser> findByFirstnameAndLastName(String firstName, String lastName) {return this.registeredUserRepository.findByFirstnameAndLastName(firstName, lastName);}
}
