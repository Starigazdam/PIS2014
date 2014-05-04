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
	private String name; // TODO: lze ziskat z enumu
	private int cost;
	
	@ManyToOne(fetch=EAGER)
	private Treatment treatment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProcedureCode getCode() {
		return code;
	}

	public void setCode(ProcedureCode code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Treatment getTreatment() {
		return treatment;
	}

	public void setTreatment(Treatment treatment) {
		this.treatment = treatment;
	}
	
	
}
