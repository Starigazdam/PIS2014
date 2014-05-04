package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Treatment;

@Stateless
public class TreatmentManager {
    @PersistenceContext
    private EntityManager em;
    
    public Treatment find(long id)
    {
    	return em.find(Treatment.class, id);
    }
    
    public void save(Treatment p)
    {
    	em.merge(p);
    }
	
    public void remove(Treatment p)
    {
    	em.remove(em.merge(p));
    }
    
    @SuppressWarnings("unchecked")
	public List<Treatment> findAll()
    {
    	return em.createQuery("SELECT t FROM Treatment t").getResultList();
    }

}
