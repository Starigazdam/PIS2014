package org.fit.pis.back;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

import org.fit.pis.data.Card;
import org.fit.pis.service.CardManager;

@ManagedBean
@SessionScoped
public class CardBean {
	@EJB
	private CardManager cardMgr;
	private Card card;
    private HtmlDataTable listTable;
	
	public CardBean() {
		card = new Card();
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	public List<Card> getCards() {
		return cardMgr.findAll();
	}

	// ====================================
	
	public HtmlDataTable getListTable() 
	{
		return listTable;
	}
	
	public void setListTable(HtmlDataTable listTable) 
	{
		this.listTable = listTable;
	}
	
    public String actionView()
    {
    	setCard((Card) listTable.getRowData());
    	return "view";
    }
	
	public String actionInsertNew()
    {
		card.setRegDate(new Date());
        cardMgr.save(card);
        return "insert";
    }
}
