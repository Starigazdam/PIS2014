package org.fit.pis.data;

public enum ProcedureCode {
	TRHANI("trhani"), 
	VRTANI("vrtani"),
	CISTENI("cisteni"), 
	PLOMBOVANI("plombovani");
	
	private final String label;

	private ProcedureCode(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
