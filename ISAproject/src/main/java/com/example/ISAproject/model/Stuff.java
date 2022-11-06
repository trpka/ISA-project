package com.example.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Stuff extends User
{
	//Ovo sam dodavao- Vezano je za prvo logovanje
	@Column
	private boolean isFirstLogin;
	
	//Jedan clan osoblja vezan je za jedan centar
	@OneToOne
    private ProfileCenter profileCenter;
	
	public boolean isFirstLogin()
	{
		return this.isFirstLogin;
	}
	public void setFirstLogin(boolean firstLogin)
	{
		this.isFirstLogin = firstLogin;
	}
	
	
	
	
}
