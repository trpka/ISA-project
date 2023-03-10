package com.example.ISAproject.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.example.ISAproject.model.BloodCenter;
import com.example.ISAproject.model.DonationTerms;
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
	 @Autowired
	    private  BloodCenterService bloodCenterService;
	 @Autowired
	    private  RegisteredUserService registeredUserService;

	 
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

		//Pretraga Korisnika Po Centrima u kojim se nalaze
		public List<RegisteredUser> findUsersByCenter(Long id)
		{
			List<RegisteredUser> all_registeredUsers = this.registeredUserRepository.findAll();
			List<RegisteredUser> finded_users = new ArrayList<>();
			BloodCenter bloodCenter = bloodCenterService.findById(id);

			for(RegisteredUser ru: all_registeredUsers)
			{
				if(ru.getBloodCenters().contains(bloodCenter))
				{

					finded_users.add(ru);
					System.out.println("Centar je  stigao");
				}
			}

			if(finded_users.isEmpty())
			{
				System.out.println("Lista je prazna");
				System.out.println("ID Centra je: " + " " + bloodCenter.getId());

			}
			return finded_users;

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

	//Sortiranja Za Korisnike
	public List<RegisteredUser> sortByName(Long id)
	{
		List<RegisteredUser> sorted_users = registeredUserRepository.findByOrderByFirstName();
		List<RegisteredUser> finded_users = new ArrayList<>();
		BloodCenter bloodCenter = bloodCenterService.findById(id);
        for ( RegisteredUser ru: sorted_users )
		{
			if(ru.getBloodCenters().contains(bloodCenter))
			{
				finded_users.add(ru);
			}
		}

		if(finded_users.isEmpty())
		{
			System.out.println("Lista je prazna");
		}
		else
		{
			System.out.println("Sortirao si me.");
		}

		return  finded_users;
	}
	public List<RegisteredUser> sortByLastName(Long id)
	{
		List<RegisteredUser> sorted_users = registeredUserRepository.findByOrderByLastName();
		List<RegisteredUser> finded_users = new ArrayList<>();
		BloodCenter bloodCenter = bloodCenterService.findById(id);
		for ( RegisteredUser ru: sorted_users )
		{
			if(ru.getBloodCenters().contains(bloodCenter))
			{
				finded_users.add(ru);
			}
		}

		if(finded_users.isEmpty())
		{
			System.out.println("Lista je prazna");
		}
		else
		{
			System.out.println("Sortirao si me po PREZIMENU.");
		}

		return  finded_users;
	}
	public List<RegisteredUser> sortById(Long id)
	{
		List<RegisteredUser> sorted_users = registeredUserRepository.findByOrderById();
		List<RegisteredUser> finded_users = new ArrayList<>();
		BloodCenter bloodCenter = bloodCenterService.findById(id);
		for ( RegisteredUser ru: sorted_users )
		{
			if(ru.getBloodCenters().contains(bloodCenter))
			{
				finded_users.add(ru);
			}
		}

		return  finded_users;

	}


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
