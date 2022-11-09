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

		/*
		 * public RegisteredUser update(RegisteredUser regUser) {
		 * Optional<RegisteredUser> regUserOpt=this.findById(regUser.getId());
		 * if(!regUserOpt.isPresent()) { return null; } RegisteredUser
		 * regUserFound=regUserOpt.get();
		 * regUserFound.setFirstName(regUser.getFirstName());
		 * regUserFound.setLastName(regUser.getLastName());
		 * regUserFound.setMobile(regUser.getMobile());
		 * regUserFound.setUsername(regUser.getUsername());
		 * regUserFound.setAdress(regUser.getAdress());
		 * regUserFound.setCity(regUser.getCity());
		 * regUserFound.setState(regUser.getState());
		 * regUserFound.setJmbg(regUser.getJmbg());
		 * regUserFound.setSex(regUser.getSex());
		 * regUserFound.setProfession(regUser.getProfession());
		 * regUserFound.setOrganizationInformation(regUser.getOrganizationInformation())
		 * ;
		 * 
		 * return this.save(regUserFound); }
		 */
     
     public RegisteredUser UpdateRegUser(RegisteredUser reg)
     {
    	 RegisteredUser regUser = registeredUserRepository.getById(reg.getId());

    	 regUser.setFirstName(reg.getFirstName());
    	 regUser.setLastName(reg.getLastName());
    	 regUser.setUsername(reg.getUsername());
         regUser.setCity(reg.getCity());
         regUser.setAdress(reg.getAdress());
         regUser.setMobile(reg.getMobile());

         return this.registeredUserRepository.save(regUser);


     }


}
