package com.example.ISAproject.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RegisteredUser extends User{

	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<DonationTerms> donationHistory;
	@Column
	private int points;
	@Column
	private String category;
	@Column
	private String benefits;

	@OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Survey> surveys;

	@ManyToOne
	@JoinColumn(name = "profile_center_id")
	private BloodCenter bloodCenter;

	//veze korisnika sa blood centrom
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="registered_user_blood_center",
			joinColumns = @JoinColumn(name = "registered_user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "blood_center_id", referencedColumnName = "id"))
	private List<BloodCenter> bloodCenters;


	public RegisteredUser(Long id, String username, String password, String email, String firstName, String lastName, String mobile, String adress, String city, String state, String jmbg, String sex, String profession, String organizationInformation, boolean enabled, Timestamp lastPasswordResetDate, String role, List<Authority> authorities, List<DonationTerms> donationHistory, int points, String category, String benefits, List<Survey> surveys, BloodCenter bloodCenter, List<BloodCenter> bloodCenters) {
		super(id, username, password, email, firstName, lastName, mobile, adress, city, state, jmbg, sex, profession, organizationInformation, enabled, lastPasswordResetDate, role, authorities);
		this.donationHistory = donationHistory;
		this.points = points;
		this.category = category;
		this.benefits = benefits;
		this.surveys = surveys;
		this.bloodCenter = bloodCenter;
		this.bloodCenters = bloodCenters;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public BloodCenter getBloodCenter() {
		return bloodCenter;
	}

	public void setBloodCenter(BloodCenter bloodCenter) {
		this.bloodCenter = bloodCenter;
	}

	public List<DonationTerms> getDonationHistory() {
		return donationHistory;
	}
	public void setDonationHistory(List<DonationTerms> donationHistory) {
		this.donationHistory = donationHistory;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public List<BloodCenter> getBloodCenters() {
		return bloodCenters;
	}

	public void setBloodCenters(List<BloodCenter> bloodCenters) {
		this.bloodCenters = bloodCenters;
	}

	public RegisteredUser() {}

	public RegisteredUser(Long id, String username, String password, String email, String firstName, String lastName, String mobile,
						  String adress, String city, String state, String jmbg, String sex, String profession, String organizationInformation,
						  boolean enabled, Timestamp lastPasswordResetDate, String role, List<Authority> authorities,
						  List<DonationTerms> donationHistory, int points, String category,
						  String benefits, List<Survey> surveys, BloodCenter bloodCenter)
	{
		super(id, username, password, email, firstName, lastName, mobile, adress, city, state, jmbg, sex, profession, organizationInformation, enabled, lastPasswordResetDate, role, authorities);
		this.donationHistory = donationHistory;
		this.points = points;
		this.category = category;
		this.benefits = benefits;
		this.surveys = surveys;
		this.bloodCenter = bloodCenter;

	}

	public RegisteredUser(String username, String password, String email, String firstName, String lastName,
						  String mobile, String adress, String city, String state, String jmbg, String sex, String profession,
						  String organizationInformation, boolean enabled, String role, List<Authority> authorities) {
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

	}






}
