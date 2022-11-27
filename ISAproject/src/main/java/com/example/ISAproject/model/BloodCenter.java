package com.example.ISAproject.model;

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
	private String startWork;
	@Column
	private String endWork;  //не може стринг
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

	//veze korisnika sa blood centrom
	@ManyToMany(mappedBy="bloodCenters")
	private Set<RegisteredUser> registered_users_for_this_center=new HashSet<>();


	public BloodCenter()
	{

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

	public String getStartWork() {
		return startWork;
	}

	public void setStartWork(String startWork) {
		this.startWork = startWork;
	}

	public String getEndWork() {
		return endWork;
	}

	public void setEndWork(String endWork) {
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

	public Set<RegisteredUser> getRegistered_users_for_this_center() {
		return registered_users_for_this_center;
	}

	public void setRegistered_users_for_this_centerregistered_users_for_this_center(Set<RegisteredUser> registered_users_for_this_center) {
		this.registered_users_for_this_center = registered_users_for_this_center;
	}

	public BloodCenter(Long id, String centerName, String address, String city, String startWork, String endWork,
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
