package org.fit.pis.back;

import javax.faces.bean.ManagedBean;

import org.fit.pis.data.ExaminationType;

@ManagedBean  
public class examinationCodeBean {
	public ExaminationType[] getCodes(){
		return ExaminationType.values();
	}
}