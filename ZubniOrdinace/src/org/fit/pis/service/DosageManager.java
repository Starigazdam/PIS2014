package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Dosage;

@Stateless
public class DosageManager 
{
    @PersistenceContext
    private EntityManager em;
    
    public Dosage find(long id)
    {
    	return em.find(Dosage.class, id);
    }

    public void save(Dosage d)
    {
    	em.merge(d);
    }
	
    public void remove(Dosage d)
    {
    	em.remove(em.merge(d));
    }
    
    @SuppressWarnings("unchecked")
    public List<Dosage> findAll()
    {
    	return em.createQuery("SELECT d FROM Dosage d").getResultList();
    }
}
