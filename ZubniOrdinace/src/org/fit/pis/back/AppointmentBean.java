package org.fit.pis.back;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import org.fit.pis.service.AppointmentManager;
import org.fit.pis.data.Appointment;

@ManagedBean
@SessionScoped
public class AppointmentBean {
	@EJB
	AppointmentManager appMgr;
	Appointment appoint;
    private HtmlDataTable listTable;
    
    public AppointmentBean() {
    	appoint = new Appointment();
    }
    
    public Appointment getAppoint() {
    	return appoint;
    }
    
    public void setAppoint(Appointment a) {
    	appoint = a;
    }
    
    public List<Appointment> getAppointments() {
    	return appMgr.findAll();
    }
    
    public List<Appointment> getRejectedAppointments() {
    	return appMgr.findAllByStatus(false);
    }
    //=============================
	public HtmlDataTable getListTable() 
	{
		return listTable;
	}
	
	public void setListTable(HtmlDataTable listTable) 
	{
		this.listTable = listTable;
	}
	
	public void actionAccept() {
		appoint = ((Appointment) listTable.getRowData());
		appoint.setAccepted(true);
		appMgr.save(appoint);
	}
	
	public String actionNew() {
		appoint = new Appointment();
		return "newappoint";
	}
}
