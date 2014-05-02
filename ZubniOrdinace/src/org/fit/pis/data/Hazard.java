package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hazard")
public class Hazard {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	private String name;
	private String description;
	
	@ManyToOne(fetch=EAGER)
	private Card patient;
}
