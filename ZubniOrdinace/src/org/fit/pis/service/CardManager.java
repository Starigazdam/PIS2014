package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Card;

@Stateless
public class CardManager 
{
    @PersistenceContext
    private EntityManager em;
    
    // TODO: pacienti so zhodnym rodnym cislom - nekonzistence
    public Card find(long id)
    {
    	return em.find(Card.class, id);
    }

    public void save(Card c)
    {
    	em.merge(c);
    }
	
    public void remove(Card c)
    {
    	em.remove(em.merge(c));
    }
    
    @SuppressWarnings("unchecked")
    public List<Card> findAll()
    {
    	return em.createQuery("SELECT c FROM Card c").getResultList();
    }
}
