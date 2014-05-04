package org.fit.pis.data;

import java.util.Collection;
																																																																																								import java.util.Date;
																																																																																								import java.util.Vector;
																																																																																																																																																																																																																																																																																																																																																																								
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "opening_day")
public class OpeningDay {
	@Id @Temporal(TemporalType.DATE)
	private Date date;
	
	@OneToMany(mappedBy = "day")
	private Collection<PublicOpeningHours> pubOpenHour;
	
	public OpeningDay() {
		pubOpenHour = new Vector<PublicOpeningHours>();
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date d) {
		this.date = d;
	}
	
	public Collection<PublicOpeningHours> getPubOpenHour() {
		return this.pubOpenHour;
	}
}
