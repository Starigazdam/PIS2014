package org.fit.pis.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToOne;

// TODO: constructor, getters, setters...

@Entity
@Table(name = "card")
public class Card {
	@Id
	private long id;	// id;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Temporal(TemporalType.DATE)
	private Date regDate;
	
	private boolean	regState;
	private long phoneNumber;
	private String email;
	private String name;
	private String surname;
	
	@OneToOne(mappedBy = "patient")
	private PatientAccount account;
	
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Illness> illnesses;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Appointment> appoints;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Tooth> toothChart;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Examination> extExams;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Hazard> hazards;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Dosage> meds;
	@OneToMany(cascade = { ALL }, fetch = EAGER, mappedBy = "patient", orphanRemoval = true)
	private Collection<Treatment> treatmentHistory;
	
	public Date getbirthDate() {
		return birthDate;
	}
	public void setbirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public boolean isRegState() {
		return regState;
	}
	public void setRegState(boolean regState) {
		this.regState = regState;
	}
	public long getid() {
		return id;
	}
	public void setid(long id) {
		this.id = id;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public PatientAccount getAccount() {
		return account;
	}
	public void setAccount(PatientAccount account) {
		this.account = account;
	}
	public Collection<Illness> getIllnesses() {
		return illnesses;
	}
	public void setIllnesses(Collection<Illness> illnesses) {
		this.illnesses = illnesses;
	}
	public Collection<Appointment> getAppoints() {
		return appoints;
	}
	public void setAppoints(Collection<Appointment> appoints) {
		this.appoints = appoints;
	}
	public Collection<Tooth> getToothChart() {
		return toothChart;
	}
	public void setToothChart(Collection<Tooth> toothChart) {
		this.toothChart = toothChart;
	}
	public Collection<Examination> getExtExams() {
		return extExams;
	}
	public void setExtExams(Collection<Examination> extExams) {
		this.extExams = extExams;
	}
	public Collection<Hazard> getHazards() {
		return hazards;
	}
	public void setHazards(Collection<Hazard> hazards) {
		this.hazards = hazards;
	}
	public Collection<Dosage> getMeds() {
		return meds;
	}
	public void setMeds(Collection<Dosage> meds) {
		this.meds = meds;
	}
	public Collection<Treatment> getTreatmentHistory() {
		return treatmentHistory;
	}
	public void setTreatmentHistory(Collection<Treatment> treatmentHistory) {
		this.treatmentHistory = treatmentHistory;
	}
	
	
}
