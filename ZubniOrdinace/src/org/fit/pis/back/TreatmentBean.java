package org.fit.pis.back;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.fit.pis.data.Treatment;
import org.fit.pis.service.TreatmentManager;
import org.richfaces.component.UIDataTable;

@ManagedBean
@SessionScoped
public class TreatmentBean {
	private Treatment treat;
	@EJB
	private TreatmentManager treatMgr;
	private UIDataTable treatlistTable;
	
	public Treatment getTreat() {
		return treat;
	}
	public void setTreat(Treatment treat) {
		this.treat = treat;
	}
	
	public UIDataTable getTreatlistTable() {
		return treatlistTable;
	}

	public void setTreatlistTable(UIDataTable treatlistTable) {
		this.treatlistTable = treatlistTable;
	}

	public void findTreat(){
		setTreat(((Treatment) treatlistTable.getRowData()));
	}
	
}


