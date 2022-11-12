package com.example.ISAproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.UserDTO;
import com.example.ISAproject.model.Authority;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RegisteredUserService registeredUserService;
	
	
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	public List<UserDTO> findAll() throws AccessDeniedException {
		List<User> users=userRepository.findAll();
		List<UserDTO> usersDTO=new ArrayList<>();
	 for (User u : users) {
		 if(!(u.getRole().equalsIgnoreCase("SysAdmin") || u.getRole().equalsIgnoreCase("Admin"))) {
			 UserDTO dto=new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(), u.getMobile(), u.getRole());
			usersDTO.add(dto);
		 }
			
		
	 }
	 return usersDTO;
	}

	
	public User save(UserDTO userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setFirstName(userRequest.getFirstName());
		u.setLastName(userRequest.getLastName());
		u.setAdress(userRequest.getAdress());
		u.setCity(userRequest.getCity());
		u.setState(userRequest.getState());
		u.setJmbg(userRequest.getJmbg());
		u.setSex(userRequest.getSex());
		u.setProfession(userRequest.getProfession());
		u.setOrganizationInformation(userRequest.getOrganizationInformation());
		
		u.setEnabled(false);
		u.setEmail(userRequest.getEmail());
		
		u.setMobile(userRequest.getMobile());
		u.setRole(userRequest.getRole());

		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		List<Authority> authorities=new ArrayList<>();
		//User newUser=new User();
		
		RegisteredUser newRegisteredUser=new RegisteredUser();
		if(u.getRole().equalsIgnoreCase("RegisteredUser")) {
			authorities = authorityService.findByName("ROLE_REGISTERED_USER");
			u.setAuthorities(authorities);
			RegisteredUser registeredUser=new RegisteredUser(u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(),u.getMobile(),u.getAdress(),u.getCity(),u.getState(),u.getJmbg(),u.getSex(),u.getProfession(),u.getOrganizationInformation(),u.isEnabled(),u.getRole(),authorities);
			newRegisteredUser=this.registeredUserService.save(registeredUser);
			u.setId(newRegisteredUser.getId());
		}

		
		System.out.println("id iz userService"+ u.getId());
		return u;
	}

}
