package org.fit.pis.data;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicine")
public class Medicine {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long code;
	
	private String name;
	private String description;
	//TODO: OneToMany to Dosage
}
