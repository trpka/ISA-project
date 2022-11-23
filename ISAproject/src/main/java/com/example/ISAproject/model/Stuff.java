package com.example.ISAproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Stuff extends User
{
	
	// Vezano je za prvo logovanje
	@Column
	private boolean isFirstLogin;
	
	//Jedan clan osoblja vezan je za jedan centar
	@OneToOne
    private BloodCenter bloodCenter;



	
	public Stuff(String username, String password, String email,String firstName, String lastName,
			String mobile, String adress, String city, String state, String jmbg, String sex, String profession,
			String organizationInformation, boolean enabled, String role, List<Authority> authorities,
				 boolean firstLogin,BloodCenter bloodCenter)
	{
		super();
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
		setMobile(mobile);
		setAdress(adress);
		setCity(city);
		setState(state);
		setJmbg(jmbg);
		setSex(sex);
		setProfession(profession);
		setOrganizationInformation(organizationInformation);
		setEnabled(enabled);
		setRole(role);
		setAuthorities(authorities);
		this.bloodCenter = bloodCenter;
		this.isFirstLogin = firstLogin;
		
	}
	
	public Stuff()
	{
		
	}

	public Stuff(String username, String password, String email,String firstName, String lastName,
				 String mobile, String adress, String city, String state, String jmbg, String sex, String profession,
				 String organizationInformation, boolean enabled, String role, List<Authority> authorities, boolean firstLogin)
	{
		super();
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setFirstName(firstName);
		setLastName(lastName);
		setMobile(mobile);
		setAdress(adress);
		setCity(city);
		setState(state);
		setJmbg(jmbg);
		setSex(sex);
		setProfession(profession);
		setOrganizationInformation(organizationInformation);
		setEnabled(enabled);
		setRole(role);
		setAuthorities(authorities);
		this.isFirstLogin = firstLogin;


	}

	//Geteri i Seteri
	public BloodCenter getBloodCenter() {
		return bloodCenter;
	}

	public void setBloodCenter(BloodCenter bloodCenter) {
		this.bloodCenter = bloodCenter;
	}

	public boolean isFirstLogin()
	{
		return this.isFirstLogin;
	}
	public void setFirstLogin(boolean firstLogin)
	{
		this.isFirstLogin = firstLogin;
	}
	
	
}
