package org.fit.pis.back;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.fit.pis.service.EmployeeManager;
import org.fit.pis.data.Employee;

@ManagedBean
@SessionScoped
public class AdminAuthBean {
	private boolean authorized;
	private String login;
	private String password;
	@EJB
	private EmployeeManager mng;
	
    public AdminAuthBean()
    {
        authorized = false;
    }

    public boolean isAuthorized()
    {
        return authorized;
    }

    public void setAuthorized(boolean authorized)
    {
        this.authorized = authorized;
    }
    
    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String actionLogout()
    {
        authorized = false;
        return "logout";
    }
    
    public String actionLogin()
    {
    	Employee temp;
    	System.out.print(login);
    	temp = (Employee) mng.find(login);
        /*if ((temp != null) && temp.getPassword().equals(password))
        {
            authorized = true;
            return "login";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid login"));
            return "failed";
        }*/
    	return "login";
    }


}
