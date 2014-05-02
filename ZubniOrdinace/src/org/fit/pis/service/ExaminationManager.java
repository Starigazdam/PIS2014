package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Examination;

@Stateless
public class ExaminationManager
{
    @PersistenceContext
    private EntityManager em;
   
    public Examination find(long id)
    {
    	return em.find(Examination.class, id);
    }

    public void save(Examination e)
    {
    	em.merge(e);
    }
	
    public void remove(Examination e)
    {
    	em.remove(em.merge(e));
    }
    
    @SuppressWarnings("unchecked")
    public List<Examination> findAll()
    {
    	return em.createQuery("SELECT e FROM Examination e").getResultList();
    }
}
