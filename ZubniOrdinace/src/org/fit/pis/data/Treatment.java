package org.fit.pis.data;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.Date;

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

}
