package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.PatientAccount;

@Stateless
public class PatientAccountManager 
{
    @PersistenceContext
    private EntityManager em;
    
    public PatientAccount find(String id)
    {
    	return em.find(PatientAccount.class, id);
    }

    public void save(PatientAccount pa)
    {
    	em.merge(pa);
    }
	
    public void remove(PatientAccount pa)
    {
    	em.remove(em.merge(pa));
    }
    
    @SuppressWarnings("unchecked")
    public List<PatientAccount> findAll()
    {
    	return em.createQuery("SELECT pa FROM PatientAccount pa").getResultList();
    }

}
