package org.fit.pis.back;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.fit.pis.data.OpeningDay;
import org.fit.pis.data.PublicOpeningHours;
import org.fit.pis.service.OpeningDayManager;
import org.fit.pis.service.PublicOpeningHoursManager;
import org.richfaces.component.UIDataTable;

@ManagedBean
@SessionScoped
public class OpenDayBean {
    @Temporal(TemporalType.TIMESTAMP)
	private Date startDay;
    @Temporal(TemporalType.TIMESTAMP)
	private Date endDay;
    @EJB
    private OpeningDayManager odMgr;
    @EJB
    private PublicOpeningHoursManager pohMgr;
    private int startHour;
    private int endHour;
    private UIDataTable listTable;
    
    public int getStartHour() {
    	return startHour;
    }
    
    public void setStartHour(int h) {
    	this.startHour = h;
    }
    
    public int getEndHour() {
    	return this.endHour;
    }
    
    public void setEndHour(int h) {
    	this.endHour = h;
    }
    
    public Date getStartDay() {
    	return this.startDay;
    }
    
    public void setStartDay(Date d) {
    	this.startDay = d;
    }
    
    public Date getEndDay() {
    	return this.endDay;
    }
    
    public void setEndDay(Date d) {
    	this.endDay = d;
    }
    
    public UIDataTable getListTable() {
    	return this.listTable;
    }
    
    public void setListTable(UIDataTable dt) {
    	this.listTable = dt;
    }
    
    public List<OpeningDay> getOpeningDays() {
    	return odMgr.findAll();
    }
    //=======================
    public void genDays() {
    	if(startHour >= endHour) return;
    	Calendar calst = Calendar.getInstance();
    	Calendar calend = Calendar.getInstance();
    	calst.setTime(startDay);
    	calend.setTime(endDay); 
    	calst.set(Calendar.HOUR_OF_DAY, startHour);
    	calst.set(Calendar.ZONE_OFFSET, -3600000);
    	calend.set(Calendar.HOUR_OF_DAY, endHour);
    	calend.set(Calendar.ZONE_OFFSET, -3600000);
    	while(calst.compareTo(calend) < 0) {
    		OpeningDay day = new OpeningDay();
    		if(odMgr.find(calst.getTime()) != null) {
        		calst.add(Calendar.DAY_OF_YEAR, 1);
    			continue;
    		}
    		day.setDate(calst.getTime());
        	calst.set(Calendar.ZONE_OFFSET, -3600000);
    		PublicOpeningHours poh = new PublicOpeningHours();
    		poh.setStartTime(calst.getTime());
    		poh.setEndTime(calend.getTime());
    		day.setPubOpenHour(poh);
    		poh.setDay(day);
    		odMgr.save(day);
    		calst.add(Calendar.DAY_OF_YEAR, 1);
    	}
    }
    
    public void actionDelete() {
    	OpeningDay d = (OpeningDay) listTable.getRowData();
    	PublicOpeningHours h = d.getPubOpenHour();
    	pohMgr.remove(h);
    	odMgr.remove(d);
    }
}
