package org.fit.pis.back;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.Card;
import org.fit.pis.data.Illness;
import org.fit.pis.service.CardManager;
import org.richfaces.component.UIDataTable;

@ManagedBean
@SessionScoped
public class CardBean {
	@EJB
	private CardManager cardMgr;
	private Card card;
	private Illness illness; 
    private UIDataTable listTable;
	
	public CardBean() {
		card = new Card();
		illness = new Illness();
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

	public List<Card> getCards() {
		return cardMgr.findAll();
	}
	
	public UIDataTable getListTable() {
		return listTable;
	}

	public void setListTable(UIDataTable listTable) {
		this.listTable = listTable;
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
}
