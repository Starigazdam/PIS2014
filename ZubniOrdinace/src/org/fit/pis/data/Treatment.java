package org.fit.pis.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "treatment")
public class Treatment {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String diagnosis;
	private String type;
	
	@ManyToOne(fetch=EAGER)
	private Card patient;
	
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "treatment", orphanRemoval = true)
	private Collection<Procedure> procedures;
	
	public Treatment() {
		procedures = new Vector<Procedure>();
	}
	
	public boolean equals(Object other)
    {
        if (other instanceof Treatment)
            return ((Treatment) other).getId() == (id);
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

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Card getPatient() {
		return patient;
	}

	public void setPatient(Card patient) {
		this.patient = patient;
	}

	public Collection<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(Collection<Procedure> procedures) {
		this.procedures = procedures;
	}

	
}
