package com.example.ISAproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BloodCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String adress;
	@Column
	private String city;
	@Column
	private String startWork;
	@Column
	private String endWork;
	@Column
	private Long grade;
	@Column
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getGrade() {
		return grade;
	}
	public void setGrade(Long grade) {
		this.grade = grade;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BloodCenter(Long id, String name, String adress, String city, String startWork, String endWork, Long grade,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.startWork = startWork;
		this.endWork = endWork;
		this.grade = grade;
		this.description = description;
	}
	public BloodCenter() {}
	
	
}
