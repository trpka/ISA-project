package com.example.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private boolean isForCenter;
	@Column
	private boolean isForStuff;
	@Column
	private String title;
	@Column
	private String content;
	@ManyToOne
	private Admin admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isForCenter() {
		return isForCenter;
	}

	public void setForCenter(boolean forCenter) {
		isForCenter = forCenter;
	}

	public boolean isForStuff() {
		return isForStuff;
	}

	public void setForStuff(boolean forStuff) {
		isForStuff = forStuff;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Complaint(Long id, boolean isForCenter, boolean isForStuff, String title, String content, Admin admin) {
		this.id = id;
		this.isForCenter = isForCenter;
		this.isForStuff = isForStuff;
		this.title = title;
		this.content = content;
		this.admin = admin;
	}

	public Complaint(){}
}
