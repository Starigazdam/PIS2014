package org.fit.pis.back;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.Appointment;
import org.fit.pis.data.Card;
import org.fit.pis.data.Dosage;
import org.fit.pis.data.Examination;
import org.fit.pis.data.Illness;
import org.fit.pis.data.Medicine;
import org.fit.pis.data.Procedure;
import org.fit.pis.data.Treatment;
import org.fit.pis.service.AppointmentManager;
import org.fit.pis.service.CardManager;
import org.richfaces.component.UIDataTable;

@ManagedBean
@SessionScoped
public class CardBean {
	@EJB
	private CardManager cardMgr;
	@EJB
	private AppointmentManager appMgr;
	private Card card;
	private Illness illness; 
	private Treatment treat;
	private Procedure proc;
	private Examination exam;
	private Dosage dosage;

	private UIDataTable listTable;
	private UIDataTable proclistTable;
	private UIDataTable treatlistTable;
	private UIDataTable illnesslistTable;
	private UIDataTable examlistTable;
	private UIDataTable dosagelistTable;
	private UIDataTable termlistTable;

	public Dosage getDosage() {
		return dosage;
	}

	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}

	public CardBean() {
		card = new Card();
		illness = new Illness();
		treat = new Treatment();
		proc = new Procedure();
		exam = new Examination();
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
    public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}
	
	public Treatment getTreat() {
		return treat;
	}

	public void setTreat(Treatment treat) {
		this.treat = treat;
	}
	
	public Procedure getProc() {
		return proc;
	}

	public void setProc(Procedure proc) {
		this.proc = proc;
	}
	
	public Examination getExam() {
		return exam;
	}

	public void setExam(Examination exam) {
		this.exam = exam;
	}

	public List<Card> getCards() {
		return cardMgr.findAll();
	}
	
	public UIDataTable getListTable() {
		return listTable;
	}

	public void setListTable(UIDataTable listTable) {
		this.listTable = listTable;
	}

	public UIDataTable getProclistTable() {
		return proclistTable;
	}

	public void setProclistTable(UIDataTable proclistTable) {
		this.proclistTable = proclistTable;
	}

	public UIDataTable getTreatlistTable() {
		return treatlistTable;
	}

	public void setTreatlistTable(UIDataTable treatlistTable) {
		this.treatlistTable = treatlistTable;
	}
	
	public UIDataTable getIllnesslistTable() {
		return illnesslistTable;
	}

	public void setIllnesslistTable(UIDataTable illnesslistTable) {
		this.illnesslistTable = illnesslistTable;
	}
	
	public UIDataTable getExamlistTable() {
		return examlistTable;
	}

	public void setExamlistTable(UIDataTable examlistTable) {
		this.examlistTable = examlistTable;
	}
	
	public UIDataTable getdosagelistTable() {
		return dosagelistTable;
	}

	public void setdosagelistTable(UIDataTable dosagelistTable) {
		this.dosagelistTable = dosagelistTable;
	}
	
	public UIDataTable getTermlistTable() {
		return this.termlistTable;
	}
	
	public void setTermlistTable(UIDataTable tlt) {
		this.termlistTable = tlt;
	}
	
	// ====================================

	public String actionView()
    {
    	setCard((Card) listTable.getRowData());
    	return "view";
    }
    
	public String actionNew()
	{
        card = new Card();
        return "newcard";
	}
	
	public String actionInsertNew()
    {
		card.setRegDate(new Date());
        cardMgr.save(card);
        return "insert";
    }
	
	public String actionUpdate()
    {
		System.out.print("update");
		cardMgr.save(card);
        return "update";
    }
	
	public String actionDelete() {
		Card selected = ((Card) listTable.getRowData());
		cardMgr.remove(selected);
		return "delete";
	}
	
	public String actionIllnessNew() {
		System.out.print("new");
		illness = new Illness();
		return "ok";
	}
	
	public String actionIllnessAdd() {
		illness.setDescription(illness.getDescription());
		illness.setFoundDate(new Date());
		illness.setPatient(card);
        card.getIllnesses().add(illness);
        return "ok";
	}
	
	public String actionIllnessAddNew() {
		//illness.setDescription(illness.getDescription());
		illness.setFoundDate(new Date());
		illness.setPatient(card);
        card.getIllnesses().add(illness);
        illness = new Illness();
        return "ok";
	}
	
	public String actionIllnessDelete() {
		Illness selected = ((Illness) illnesslistTable.getRowData());
		card.getIllnesses().remove(selected);
		return "illdel";
	}
	
	public String actionTreatNew() {
		treat = new Treatment();
		return "newtreat";
	}
	
	public String actionTreatAdd() {
		treat.setPatient(card);
		treat.setDate(new Date());
		card.getTreatmentHistory().add(treat);
		return "treatadd";
	}
	
	public String actionTreatDelete() {
		Treatment selected = ((Treatment) treatlistTable.getRowData());
		card.getTreatmentHistory().remove(selected);
		return "treatdel";
	}

	public String actionProcAddNew() {
		proc.setTreatment(treat);
		proc.setName(proc.getCode().name());
		treat.getProcedures().add(proc);
		proc = new Procedure();
		return "addproc";
	}
	
	public String actionProcNew() {
		proc = new Procedure();
		return "newproc";
	}
	
	public String actionProcAdd() {
		proc.setTreatment(treat);
		proc.setName(proc.getCode().name());
		treat.getProcedures().add(proc);
		return "addproc";
	}
	
	public String actionExamDelete() {
		System.out.print("EXDEL");
		Examination selected = ((Examination) examlistTable.getRowData());
		card.getExtExams().remove(selected);
		return "examdel";
	}
	
	public String actionExamAddNew() {
		//illness.setDescription(illness.getDescription());
		exam.setDate(new Date());
		exam.setPatient(card);
        card.getExtExams().add(exam);
        exam = new Examination();
        return "ok";
	}
	
	public String actionDosageNew() {
		dosage = new Dosage();
		dosage.setMed(new Medicine());
		return "newdosage";
	}
	
	public String actionDosageAdd() {
		dosage.setPatient(card);
		card.getMeds().add(dosage);
		return "dosageadd";
	}
	
	public String actionDosageDelete() {
		Dosage selected = ((Dosage) dosagelistTable.getRowData());
		card.getMeds().remove(selected);
		return "dosagedel";
	}

	public String actionProcDelete() {
		Procedure selected = ((Procedure) proclistTable.getRowData());
		selected.getTreatment().getProcedures().remove(selected);
		return "procdel";
	}
	
	public String actionTermRemove() {
        Appointment app = ((Appointment) termlistTable.getRowData());
        appMgr.remove(app);
        return "";
	}
	
	public String actionTermAccept() {		
		Appointment appoint = ((Appointment) termlistTable.getRowData());
		appoint.setAccepted(true);
		appMgr.save(appoint);
		return "";
	}

	public String actionTermReject() {
		Appointment appoint = ((Appointment) termlistTable.getRowData());
		appoint.setAccepted(false);
		appMgr.save(appoint);
		return "";
	}

}
