package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Illness;

@Stateless
public class IllnessManager 
{
    @PersistenceContext
    private EntityManager em;
   
    public Illness find(long id)
    {
    	return em.find(Illness.class, id);
    }

    public void save(Illness i)
    {
    	em.merge(i);
    }
	
    public void remove(Illness i)
    {
    	em.remove(em.merge(i));
    }
    
    @SuppressWarnings("unchecked")
    public List<Illness> findAll()
    {
    	return em.createQuery("SELECT i FROM Illness i").getResultList();
    }
}
