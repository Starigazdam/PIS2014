package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.richfaces.component.UIDataTable;

import org.fit.pis.service.AppointmentManager;
import org.fit.pis.data.Appointment;

@ManagedBean
@SessionScoped
public class AppointmentBean {
	@EJB
	AppointmentManager appMgr;
	Appointment appoint;
    private UIDataTable listTable;
    
    public AppointmentBean() {
    	this.appoint = new Appointment();
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
