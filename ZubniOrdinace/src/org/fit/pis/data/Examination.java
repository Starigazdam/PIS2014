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
@Table(name = "examination")
public class Examination {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private ExaminationType type;
	private String description;
	
	@ManyToOne(fetch=EAGER)
	private Card patient;
	
	
	public Examination(){
		type = ExaminationType.UNSPEC;
	}
	
    public boolean equals(Object other)
    {
        if (other instanceof Examination)
            return ((Examination) other).getId() == (id);
        else
            return false;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ExaminationType getType() {
		return type;
	}

	public void setType(ExaminationType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Card getPatient() {
		return patient;
	}

	public void setPatient(Card patient) {
		this.patient = patient;
	}
}
