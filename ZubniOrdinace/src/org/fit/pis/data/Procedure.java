package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "_procedure")
public class Procedure {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	private ProcedureCode code;
	private String name; // TODO: nelze toto ziskat priamo z enumu cez nejaky konstruktor?
	private int cost;
	
	@ManyToOne(fetch=EAGER)
	private Treatment treatment;
}
