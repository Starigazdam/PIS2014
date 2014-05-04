package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;

import java.lang.String;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class PatientAccount {	   
	@Id
	private String user;
	private String password;
	
	@OneToOne(fetch=EAGER)
	private Card patient;

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Card getPatient() {
		return patient;
	}
	
	public void setPatient(Card c) {
		this.patient = c;
	}
   
}
