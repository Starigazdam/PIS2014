package org.fit.pis.service;

import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Appointment;

@Stateless
public class AppointmentManager 
{
    @PersistenceContext
    private EntityManager em;
    
    public Appointment find(long id)
    {
    	return em.find(Appointment.class, id);
    }

    public void save(Appointment ap)
    {
    	em.merge(ap);
    }
	
    public void remove(Appointment ap)
    {
    	em.remove(em.merge(ap));
    }
    
    @SuppressWarnings("unchecked")
    public List<Appointment> findAll()
    {
    	return em.createQuery("SELECT ap FROM Appointment ap").getResultList();
    }
    
    public Object findByDate(Date date)
    {
    	try {
    		return em.createQuery("SELECT ap FROM Appointment ap WHERE ap.date = :val").setParameter("val", date).getSingleResult();
    	}
    	catch (javax.persistence.NoResultException e) {
    		return null;	
    	}
    }

    @SuppressWarnings("unchecked")
    public List<Appointment> findAllByStatus(boolean status) {
    	return em.createQuery("SELECT ap From Appointment ap WHERE ap.accepted = :val").setParameter("val", status).getResultList();
    }

}
