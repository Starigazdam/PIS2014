package org.fit.pis.data;

import java.util.Date;
																																																																																																																																																																																																																																																																																																																																																																																																																																																											
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "opening_day")
public class OpeningDay {
	@Id @Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToOne(mappedBy = "day")
	private PublicOpeningHours pubOpenHour;
	
	public OpeningDay() {
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date d) {
		this.date = d;
	}
	
	public PublicOpeningHours getPubOpenHour() {
		return this.pubOpenHour;
	}
	
	public void setPubOpenHour(PublicOpeningHours poh) {
		this.pubOpenHour = poh;
	}
}
