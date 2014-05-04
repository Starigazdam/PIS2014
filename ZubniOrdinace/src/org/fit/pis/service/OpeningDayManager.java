package org.fit.pis.service;

import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.OpeningDay;

@Stateless
public class OpeningDayManager 
{
    @PersistenceContext
    private EntityManager em;
    
    public OpeningDay find(Date id)
    {
    	return em.find(OpeningDay.class, id);
    }

    public void save(OpeningDay ap)
    {
    	em.merge(ap);
    }
	
    public void remove(OpeningDay ap)
    {
    	em.remove(em.merge(ap));
    }
    
    @SuppressWarnings("unchecked")
    public List<OpeningDay> findAll()
    {
    	return em.createQuery("SELECT ap FROM OpeningDay ap").getResultList();
    }
}