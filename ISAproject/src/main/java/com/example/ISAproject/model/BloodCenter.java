package com.example.ISAproject.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class BloodCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String centerName;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private LocalDateTime startWork;
	@Column
	private LocalDateTime endWork;
	@Column
	private String description;
	@Column
	private Long averageGradeCentre;
	//krvne grupe i kolicine krvi po grupama
	@Column
	private double bloodA;
	@Column
	private double bloodB;
	@Column
	private double bloodAB;
	@Column
	private double bloodO;

	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<DonationTerms> freeAppointments;

	//Centar sa administratorima i osobljem
	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Stuff> listOfStuffs;

	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<RegisteredUser> registeredUsers;

	//veze korisnika sa blood centrom
	@ManyToMany(mappedBy="bloodCenters")
	private List<RegisteredUser> registered_users_for_this_center;


	public BloodCenter()
	{

	}

	public BloodCenter(Long id, String centerName, String address, String city, LocalDateTime startWork, LocalDateTime endWork, String description, Long averageGradeCentre, double bloodA, double bloodB, double bloodAB, double bloodO, List<DonationTerms> freeAppointments, List<Stuff> listOfStuffs, List<RegisteredUser> registeredUsers) {
		this.id = id;
		this.centerName = centerName;
		this.address = address;
		this.city = city;
		this.startWork = startWork;
		this.endWork = endWork;
		this.description = description;
		this.averageGradeCentre = averageGradeCentre;
		this.bloodA = bloodA;
		this.bloodB = bloodB;
		this.bloodAB = bloodAB;
		this.bloodO = bloodO;
		this.freeAppointments = freeAppointments;
		this.listOfStuffs = listOfStuffs;
		this.registeredUsers = registeredUsers;
	}

	public List<RegisteredUser> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(List<RegisteredUser> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDateTime getStartWork() {
		return startWork;
	}

	public void setStartWork(LocalDateTime startWork) {
		this.startWork = startWork;
	}

	public LocalDateTime getEndWork() {
		return endWork;
	}

	public void setEndWork(LocalDateTime endWork) {
		this.endWork = endWork;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAverageGradeCentre() {
		return averageGradeCentre;
	}

	public void setAverageGradeCentre(Long averageGradeCentre) {
		this.averageGradeCentre = averageGradeCentre;
	}

	public double getBloodA() {
		return bloodA;
	}

	public void setBloodA(double bloodA) {
		this.bloodA = bloodA;
	}

	public double getBloodB() {
		return bloodB;
	}

	public void setBloodB(double bloodB) {
		this.bloodB = bloodB;
	}

	public double getBloodAB() {
		return bloodAB;
	}

	public void setBloodAB(double bloodAB) {
		this.bloodAB = bloodAB;
	}

	public double getBloodO() {
		return bloodO;
	}

	public void setBloodO(double bloodO) {
		this.bloodO = bloodO;
	}

	public List<DonationTerms> getFreeAppointments() {
		return freeAppointments;
	}

	public void setFreeAppointments(List<DonationTerms> freeAppointments) {
		this.freeAppointments = freeAppointments;
	}

	public List<Stuff> getListOfStuffs() {
		return listOfStuffs;
	}

	public void setListOfStuffs(List<Stuff> listOfStuffs) {
		this.listOfStuffs = listOfStuffs;
	}





	public BloodCenter(Long id, String centerName, String address, String city, LocalDateTime startWork, LocalDateTime endWork,
					   String description, Long averageGradeCentre, double bloodA, double bloodB, double bloodAB,
					   double bloodO, List<DonationTerms> freeAppointments, List<Stuff> listOfStuffs)
	{
		this.id = id;
		this.centerName = centerName;
		this.address = address;
		this.city = city;
		this.startWork = startWork;
		this.endWork = endWork;
		this.description = description;
		this.averageGradeCentre = averageGradeCentre;
		this.bloodA = bloodA;
		this.bloodB = bloodB;
		this.bloodAB = bloodAB;
		this.bloodO = bloodO;
		this.freeAppointments = freeAppointments;
		this.listOfStuffs = listOfStuffs;
	}

	public BloodCenter(Long id, String centerName, String address, String description, Long averageGradeCentre,
					   double bloodA, double bloodB, double bloodAB, double bloodO,
					   List<DonationTerms> freeAppointments, List<Stuff> listOfStuffs)
	{
		this.id = id;
		this.centerName = centerName;
		this.address = address;
		this.description = description;
		this.averageGradeCentre = averageGradeCentre;
		this.bloodA = bloodA;
		this.bloodB = bloodB;
		this.bloodAB = bloodAB;
		this.bloodO = bloodO;
		this.freeAppointments = freeAppointments;
		this.listOfStuffs = listOfStuffs;
	}

	public BloodCenter(Long id, String centerName, String address, String description, Long averageGradeCentre,
					   double bloodA, double bloodB, double bloodAB, double bloodO,
					   List<Stuff> listOfStuffs)
	{
		this.id = id;
		this.centerName = centerName;
		this.address = address;
		this.description = description;
		this.averageGradeCentre = averageGradeCentre;
		this.bloodA = bloodA;
		this.bloodB = bloodB;
		this.bloodAB = bloodAB;
		this.bloodO = bloodO;
		//this.freeAppointments = freeAppointments;
		this.listOfStuffs = listOfStuffs;
	}


}
