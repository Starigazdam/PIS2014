package org.fit.pis.back;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.richfaces.component.UIDataTable;
import org.fit.pis.service.PublicOpeningHoursManager;
import org.fit.pis.data.PublicOpeningHours;
import org.fit.pis.service.AppointmentManager;
import org.fit.pis.data.Appointment;

@ManagedBean
@SessionScoped
public class AppointmentBean {
	@EJB
	AppointmentManager appMgr;
	@EJB
	PublicOpeningHoursManager pohMgr;
	Appointment appoint;
	Date date;
	private UIDataTable listTable;
    private UIDataTable freeTable;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    public UIDataTable getFreeTable() {
		return freeTable;
	}

	public void setFreeTable(UIDataTable freeTable) {
		this.freeTable = freeTable;
	}

	public AppointmentBean() {
    	this.appoint = new Appointment();
    	this.date = new Date();
    }
    
    public Appointment getAppoint() {
    	return appoint;
    }
    
    public void setAppoint(Appointment a) {
    	this.appoint = a;
    }
    
    public List<Appointment> getAppointments() {
    	return appMgr.findAll();
    }
    
    public List<Appointment> getRejectedAppointments() {
    	return appMgr.findAllByStatus(false);
    }
    public List<Integer> getFreeAppointments() {
    	List<Integer> lol = new ArrayList<Integer>();
    	PublicOpeningHours temp = (PublicOpeningHours) pohMgr.findByDate(date);
    	if (temp != null)
    		for (int i=0, j=temp.getStartTime().getHours(); j<temp.getEndTime().getHours(); i++, j++) {
    			lol.add(i, j);
    		}
    	return lol;
    }
    //=============================
	public UIDataTable getListTable() 
	{
		return listTable;
	}
	
	public void setListTable(UIDataTable lt) 
	{
		this.listTable = lt;
	}
	
	public void actionAccept() {		
		this.appoint = ((Appointment) listTable.getRowData());
		this.appoint.setAccepted(true);
		appMgr.save(this.appoint);
	}

	public void actionReject() {
		this.appoint = ((Appointment) listTable.getRowData());
		this.appoint.setAccepted(false);
		appMgr.save(this.appoint);
	}
	
	public String actionNew() {
		appoint = new Appointment();
		return "newappoint";
	}
	
}
