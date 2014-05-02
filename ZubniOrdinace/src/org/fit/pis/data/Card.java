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
	private long birthNumber;

	@Temporal(TemporalType.DATE)
	private Date regDate;
	
	private boolean	regState;
	private long	healthInsuranceNumber;
	private int	phoneNumber;
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
}
