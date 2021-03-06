package org.fit.pis.data;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "public_opening_hours")
public class PublicOpeningHours {
	@Id @GeneratedValue(strategy = IDENTITY)
	private long id;
	
	@Temporal(TemporalType.TIME)
	private Date startTime;
	@Temporal(TemporalType.TIME)
	private Date endTime;

	@OneToOne(fetch=EAGER)
	private OpeningDay day;
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public OpeningDay getDay() {
		return this.day;
	}
	
	public void setDay(OpeningDay d) {
		this.day = d;
	}
}
