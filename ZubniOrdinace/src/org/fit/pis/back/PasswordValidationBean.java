package org.fit.pis.back;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.fit.pis.data.PatientAccount;
import org.fit.pis.service.PatientAccountManager;

@ManagedBean
@SessionScoped
public class PasswordValidationBean implements Cloneable, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1952428504080910113L;
    @Size(min = 5, max = 15, message = "Délka hesla musí být od {min} do {max} znakù.")
    private String password = "";
    private String confirm = "";
    @EJB
    private PatientAccountManager paMgr;
    @AssertTrue(message = "Hesla nesouhlasí!")
    public boolean isPasswordsEquals() {
        return password.equals(confirm);
    }
 
    public void storeNewPassword(String user) {
    	PatientAccount pa = paMgr.find(user);
    	pa.setPassword(password);
    	paMgr.save(pa);
    	FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Heslo zmìnìno!", "Heslo zmìnìno!"));
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
 
    public String getPassword() {
        return password;
    }
 
    public String getConfirm() {
        return confirm;
    }
 
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
