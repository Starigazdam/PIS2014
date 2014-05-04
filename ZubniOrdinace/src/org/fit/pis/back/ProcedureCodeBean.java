package org.fit.pis.back;

import javax.faces.bean.ManagedBean;

import org.fit.pis.data.ProcedureCode;

@ManagedBean  
public class ProcedureCodeBean
{
	public ProcedureCode[] getCodes(){
		System.out.print("PROCBEAN");
		return ProcedureCode.values();
	}
}
