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
import org.fit.pis.service.PatientAccountManager;
import org.fit.pis.service.PublicOpeningHoursManager;
import org.fit.pis.service.OpeningDayManager;
import org.fit.pis.data.PublicOpeningHours;
import org.fit.pis.service.AppointmentManager;
import org.fit.pis.data.Appointment;
import org.fit.pis.service.CardManager;
import org.fit.pis.data.Card;

@ManagedBean
@SessionScoped
public class AppointmentBean {
	@EJB
	private AppointmentManager appMgr;
	@EJB
	private PublicOpeningHoursManager pohMgr;
	@EJB
	private PatientAccountManager paMgr;
	@EJB
	private CardManager cMgr;
	@EJB
	private OpeningDayManager odMgr;
	private Appointment appoint;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private UIDataTable listTable;
    private UIDataTable freeTable;
    private UIDataTable historyTable;

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
    
    public UIDataTable getListTable() 
	{
		return listTable;
	}
	
	public void setListTable(UIDataTable lt) 
	{
		this.listTable = lt;
	}
	
	public UIDataTable getHistoryTable() {
		return historyTable;
	}

	public void setHistoryTable(UIDataTable historyTable) {
		this.historyTable = historyTable;
	}
    
    //=============================
	
    public List<Appointment> getAppointments() {
    	return appMgr.findAll();
    }
    
    public List<Appointment> getRejectedAppointments() {
    	return appMgr.findAllByStatus(false);
    }
    public List<Integer> getFreeAppointments() {
    	List<Integer> lol = new ArrayList<Integer>();
    	Appointment appointment;
    	date.setMinutes(0);
    	date.setSeconds(0);
    	PublicOpeningHours temp = (PublicOpeningHours) pohMgr.findByDate(date);
    	if (temp != null)
    		for (int j=temp.getStartTime().getHours(); j<temp.getEndTime().getHours(); j++) {
    			Date newdate = (Date) date.clone();
    			newdate.setHours(j);
    			System.out.println(newdate);
    			appointment = (Appointment)appMgr.findByDate(newdate);
    			if (appointment == null)
    				lol.add(j);
    		}
    	return lol;
    }
    public List<Appointment> getAppHistory(String user) {
    	return appMgr.findAllByCard(paMgr.find(user).getPatient());
    }
	
    public List<Appointment> getIDAppHistory(Long user) {
    	return appMgr.findAllByCard(cMgr.find(user));
    }
    
	public String actionAccept() {		
		this.appoint = ((Appointment) listTable.getRowData());
		this.appoint.setAccepted(true);
		appMgr.save(this.appoint);
		return "";
	}

	public String actionReject() {
		this.appoint = ((Appointment) listTable.getRowData());
		this.appoint.setAccepted(false);
		appMgr.save(this.appoint);
		return "";
	}
	
	public String actionNew() {
		appoint = new Appointment();
		return "newappoint";
	}
	
	public String actionSubmit(Integer i, String user) {
		Card card = paMgr.find(user).getPatient();
		Appointment newAppoint = new Appointment();
		Date newdate = (Date) date.clone();
		newdate.setHours(i);
		newAppoint.setDate(newdate);
		newAppoint.setPatient(card);
		newAppoint.setAccepted(false);
		newAppoint.setOpenday(odMgr.find(this.date));
		appMgr.save(newAppoint);
		System.out.println(user);
		return "submit";
	}
	
	public String actionIDSubmit(Integer i, Long user) {
		Card card = cMgr.find(user);
		Appointment newAppoint = new Appointment();
		Date newdate = (Date) date.clone();
		newdate.setHours(i);
		newAppoint.setDate(newdate);
		newAppoint.setPatient(card);
		newAppoint.setAccepted(false);
		newAppoint.setOpenday(odMgr.find(this.date));
		appMgr.save(newAppoint);
		System.out.println(user);
		return "submit";
	}
	
	
   public String actionRemove() {
               Appointment app = ((Appointment) listTable.getRowData());
               appMgr.remove(app);
               return "";
   }
   
   public String actionHistoryRemove() {
       Appointment app = ((Appointment) historyTable.getRowData());
       appMgr.remove(app);
       return "";
   }

}
