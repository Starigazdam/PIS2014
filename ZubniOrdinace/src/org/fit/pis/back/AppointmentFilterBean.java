package org.fit.pis.back;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.richfaces.model.Filter;
import org.fit.pis.data.Appointment;

@ManagedBean
@ViewScoped
public class AppointmentFilterBean implements Serializable {
	private static final long serialVersionUID = -5680001353441022183L;
    private Boolean acceptFilter;
	@Temporal(TemporalType.DATE)
	private Date dateFilter;
	
	@PostConstruct
	public void init() {
		dateFilter = new Date();
	}
	
    public Filter<?> getAcceptFilterImpl() {
        return new Filter<Appointment>() {
            public boolean accept(Appointment item) {
                Boolean mAcc = getAcceptFilter();
                if (mAcc == null || mAcc.equals(item.isAccepted())) {
                    return true;
                }
                return false;
            }
        };
    }
 
    public Filter<?> getFilterDate() {
        return new Filter<Appointment>() {
            public boolean accept(Appointment t) {
                Date date = getDateFilter();
                if (date == null  || (date.compareTo(t.getDate()) <= 0)) {
                    return true;
                }
                return false;
            }
        };
    }
 
    public Boolean getAcceptFilter() {
    	return acceptFilter;
    }
    
    public void setAcceptFilter(Boolean b) {
    	this.acceptFilter = b;
    }
    
    public Date getDateFilter() {
    	return dateFilter;
    }
    
    public void setDateFilter(Date d) {
    	this.dateFilter = d;
    }
}
