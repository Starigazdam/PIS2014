package org.fit.pis.back;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.fit.pis.service.PatientAccountManager;
import org.fit.pis.data.PatientAccount;

@ManagedBean
@SessionScoped
public class UserAuthBean {
	private boolean authorized;
	private String login;
	private String password;
	@EJB
	private PatientAccountManager mng;
	
    public UserAuthBean()
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
    	PatientAccount temp;
    	temp = (PatientAccount) mng.find(login);
        //if ((temp != null) && temp.getPassword().equals(password))
        if(login.equals("user") && password.equals("user"))
    	{
            authorized = true;
            return "login";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid login"));
            return "failed";
        }
    }


}