package com.example.ISAproject.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class ProfileCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String centerName;
	@Column
	private String adress;
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
	
	
	
}
