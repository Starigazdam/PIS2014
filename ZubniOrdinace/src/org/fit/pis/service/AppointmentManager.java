package org.fit.pis.service;

import java.util.List;

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

}
