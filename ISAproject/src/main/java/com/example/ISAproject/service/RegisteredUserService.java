package com.example.ISAproject.service;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.Stuff;
import com.example.ISAproject.repository.BloodCenterRepository;
import com.example.ISAproject.repository.RegisteredUserRepository;

@Service
public class RegisteredUserService {

	 @Autowired
	    private RegisteredUserRepository registeredUserRepository;
	 
		/*
		 * public Optional<RegisteredUser> findById(Long id) { return
		 * this.registeredUserRepository.findById(id); }
		 */
	 
	 public RegisteredUser findById(Long id)
	    {
	        Optional<RegisteredUser> opt=this.registeredUserRepository.findById(id);
	        if(!opt.isPresent())
	        {
	            return null;
	        }
	        
	        return opt.get();
	    }
	 
     public RegisteredUser save(RegisteredUser newRegUser) {
			return this.registeredUserRepository.save(newRegUser);
		}
    

     public List<RegisteredUser> findAll() { return this.registeredUserRepository.findAll();}
	
		 
		  public RegisteredUser UpdateRegUser(RegisteredUser reg)
		    {
			  RegisteredUser regUser = registeredUserRepository.getById(reg.getId());

			  regUser.setFirstName(reg.getFirstName());
			  regUser.setLastName(reg.getLastName());
			  regUser.setUsername(reg.getUsername()); 
			  regUser.setMobile(reg.getMobile());
			  regUser.setAdress(reg.getAdress()); 
			  regUser.setCity(reg.getCity());
			  regUser.setState(reg.getState()); 
			  regUser.setJmbg(reg.getJmbg());
			  regUser.setSex(reg.getSex()); 
			  regUser.setProfession(reg.getProfession());
			  regUser.setOrganizationInformation(reg.getOrganizationInformation());
			  
			  return this.registeredUserRepository.save(regUser);
			  


		    }

	 public List<RegisteredUser> findByFirstName(String name) {return this.registeredUserRepository.findByFirstName(name);}
	 public List<RegisteredUser> findByLastName(String lastName){ return this.registeredUserRepository.findByLastName(lastName);}


	public RegisteredUser activateById(Long id) {
		Optional<RegisteredUser> registeredUserOpt= Optional.ofNullable(this.findById(id));
		if(!registeredUserOpt.isPresent()) {
			return null;
		}
		RegisteredUser registeredUser=registeredUserOpt.get();
		registeredUser.setEnabled(true);
		//client.setEnabled(true);
		return registeredUser;
	}

}
