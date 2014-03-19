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
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;
	private ExaminationType type;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String description;
	@ManyToOne(fetch=EAGER)
	private Card patient;
}
