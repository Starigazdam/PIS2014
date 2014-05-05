package org.fit.pis.back;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.Card;
import org.fit.pis.service.CardManager;
import org.fit.pis.data.PatientAccount;
import org.fit.pis.service.PatientAccountManager;
import org.richfaces.component.UIDataTable;


@ManagedBean
@SessionScoped
public class CardAccBean {
	@EJB
	private CardManager cardMgr;
	private Card card;
	@EJB
	private PatientAccountManager ptMgr;

	private UIDataTable listTable;

	public CardAccBean() {
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
	
	public UIDataTable getListTable() {
		return listTable;
	}

	public void setListTable(UIDataTable listTable) {
		this.listTable = listTable;
	}
	
	// ====================================
	
	public String actionUpdate()
    {
		cardMgr.save(card);
        return "update";
    }
	
	public String actionNewAcc()
	{
		Card c = (Card) listTable.getRowData();

		PatientAccount p = new PatientAccount();
		StringBuilder prefix = new StringBuilder(c.getName());
		StringBuilder sb = prefix;
		int x = 0;
		while(ptMgr.find(sb.toString()) != null) {
			sb = prefix;
			x++;
			sb.append(x);
		}
		char[] chars = "abcdefghijklmnopqrstvuwxyz1234567890".toCharArray();
		StringBuilder sb2 = new StringBuilder();
		Random r = new Random();
		for (int i = 0; i < 9; i++) {
		    char ch = chars[r.nextInt(chars.length)];
		    sb2.append(ch);
		}
		p.setUser(sb.toString());
		p.setPassword(sb2.toString());
		p.setPatient(c);
		c.setAccount(p);
		cardMgr.save(c);
		
		return "";
	}
	
	public String actionRemAcc()
	{
		Card c = (Card) listTable.getRowData();
		PatientAccount p = c.getAccount();
		ptMgr.remove(p);
		c.setAccount(null);
		cardMgr.save(c);
		return "delete";
	}

}
