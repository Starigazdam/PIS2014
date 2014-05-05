package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dosage")
public class Dosage {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private int dosage;
	private String note;
	
	@ManyToOne(fetch=EAGER)
	private Medicine med;
	@ManyToOne(fetch=EAGER)
	private Card patient;
	
    public boolean equals(Object other)
    {
        if (other instanceof Dosage)
            return ((Dosage) other).getId() == (id);
        else
            return false;
    }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Medicine getMed() {
		return med;
	}
	public void setMed(Medicine med) {
		this.med = med;
	}
	public Card getPatient() {
		return patient;
	}
	public void setPatient(Card patient) {
		this.patient = patient;
	}
}
