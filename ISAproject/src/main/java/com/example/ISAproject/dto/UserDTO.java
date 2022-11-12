package com.example.ISAproject.dto;

import com.example.ISAproject.model.User;

import javax.persistence.Column;

public class UserDTO {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobile;
	private String adress;
	private String city;
	private String state;
	private String jmbg;
	private String sex;
	private String profession;
	private String organizationInformation;
	private String role;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getOrganizationInformation() {
		return organizationInformation;
	}

	public void setOrganizationInformation(String organizationInformation) {
		this.organizationInformation = organizationInformation;
	}

	public UserDTO(String username, String password, String email, String firstName, String lastName, String mobile, String adress, String city, String state, String jmbg, String sex, String profession, String organizationInformation, String role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.adress = adress;
		this.city = city;
		this.state = state;
		this.jmbg = jmbg;
		this.sex = sex;
		this.profession = profession;
		this.organizationInformation = organizationInformation;
		this.role = role;
	}

	public UserDTO() {}

	public UserDTO(Long id, String username, String password, String email, String firstName, String lastName,
				   String mobile, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.role = role;
	}



}
