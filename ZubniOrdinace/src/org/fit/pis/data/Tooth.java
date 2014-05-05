package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tooth")
public class Tooth {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	private int state;
	private int position;
	
	@ManyToOne(fetch=EAGER)
	private Card patient;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Card getPatient() {
		return patient;
	}

	public void setPatient(Card patient) {
		this.patient = patient;
	}

}
