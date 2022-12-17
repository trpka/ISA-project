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
import org.springframework.security.access.prepost.PreAuthorize;

@Entity
//@PreAuthorize("hasRole('STUFF') or hasRole('ADMIN')")
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@Column
	//private Stuff stuff;
	
	
	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<DonationTerms> donationTerms;

	public Calendar(Long id, List<DonationTerms> donationTerms) {
		super();
		this.id = id;
		this.donationTerms = donationTerms;
	}

	public Calendar() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DonationTerms> getDonationTerms() {
		return donationTerms;
	}

	public void setDonationTerms(List<DonationTerms> donationTerms) {
		this.donationTerms = donationTerms;
	}

	
	
}
