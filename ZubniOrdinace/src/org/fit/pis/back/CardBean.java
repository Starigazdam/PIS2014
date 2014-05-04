package org.fit.pis.back;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.Card;
import org.fit.pis.data.Illness;
import org.fit.pis.data.Procedure;
import org.fit.pis.data.Treatment;
import org.fit.pis.service.CardManager;
import org.richfaces.component.UIDataTable;

@ManagedBean
@SessionScoped
public class CardBean {
	@EJB
	private CardManager cardMgr;
	private Card card;
	private Illness illness; 
	private Treatment treat;
	private Procedure proc;

	private UIDataTable listTable;
	private UIDataTable proclistTable;
	private UIDataTable treatlistTable;

	public CardBean() {
		card = new Card();
		illness = new Illness();
		treat = new Treatment();
		proc = new Procedure();
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
		System.out.print("add");
		illness.setFoundDate(new Date());
		illness.setPatient(card);
        card.getIllnesses().add(illness);
        return "ok";
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
}
