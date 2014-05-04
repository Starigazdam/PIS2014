package org.fit.pis.service;

import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Appointment;
import org.fit.pis.data.PublicOpeningHours;

@Stateless
public class PublicOpeningHoursManager 
{
    @PersistenceContext
    private EntityManager em;
    
    public PublicOpeningHours find(long id)
    {
    	return em.find(PublicOpeningHours.class, id);
    }

    public void save(PublicOpeningHours ap)
    {
    	em.merge(ap);
    }
	
    public void remove(PublicOpeningHours ap)
    {
    	em.remove(em.merge(ap));
    }
    
    @SuppressWarnings("unchecked")
    public List<PublicOpeningHours> findAll()
    {
    	return em.createQuery("SELECT ap FROM PublicOpeningHours ap").getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public Object findByDate(Date date)
    {
    	try {
    		return em.createQuery("SELECT oh FROM PublicOpeningHours oh INNER JOIN OpeningDay od WHERE od.date = :val").setParameter("val", date).getSingleResult();
    	}
    	catch (javax.persistence.NoResultException e) {
    		return null;	
    	}
    }
}