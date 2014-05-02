package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Hazard;

@Stateless
public class HazardManager 
{
    @PersistenceContext
    private EntityManager em;
   
    public Hazard find(long id)
    {
    	return em.find(Hazard.class, id);
    }

    public void save(Hazard h)
    {
    	em.merge(h);
    }
	
    public void remove(Hazard h)
    {
    	em.remove(em.merge(h));
    }
    
    @SuppressWarnings("unchecked")
    public List<Hazard> findAll()
    {
    	return em.createQuery("SELECT h FROM Hazard h").getResultList();
    }
}
