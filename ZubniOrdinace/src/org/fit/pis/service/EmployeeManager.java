package org.fit.pis.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.fit.pis.data.Employee;


@Stateless
public class EmployeeManager 
{
	@PersistenceContext
    private EntityManager em;
	
    public Employee find(String id)
    {
    	return em.find(Employee.class, id);
    }
    
    public List<Employee> findBegining(String id)
    {
        String pref = id + "%";
        @SuppressWarnings("unchecked")
		List<Employee> ret = em.createQuery("SELECT e FROM Employee e WHERE e.user LIKE :pref").setParameter("pref", pref).getResultList();
    	return ret;
    }
    
    public void save(Employee p)
    {
    	em.merge(p);
    }
	
    public void remove(Employee p)
    {
    	em.remove(em.merge(p));
    }
    
    @SuppressWarnings("unchecked")
	public List<Employee> findAll()
    {
    	return em.createQuery("SELECT e FROM Employee e").getResultList();
    }
}