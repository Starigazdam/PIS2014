package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "illness")
public class Illness {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private Date date;
	private String description;
	@ManyToOne(fetch=EAGER)
	private Card patient;

}
