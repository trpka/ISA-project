package com.example.ISAproject.model;

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
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column
	//private Stuff stuff;
	
	//termini koji su unapred definisani
	/*
	 * @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	 * 
	 * @JsonIgnore private List<DonationTerms> reservedTerms;
	 */
	
}
