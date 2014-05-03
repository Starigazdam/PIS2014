package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String note;
	private boolean accepted;
	
	@ManyToOne(fetch=EAGER)
	private Card patient;
	@ManyToOne(fetch=EAGER)
	private OpeningDay openday;
	
	public boolean isAccepted() {
		return accepted;
	}
	
	public void setAccepted(boolean b) {
		accepted = b;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date d) {
		date = d;
	}
	
	public Card getPatient() {
		return patient;
	}
	
	public void setPatient(Card c) {
		this.patient = c;
	}
}
