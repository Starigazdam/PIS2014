package org.fit.pis.data;

public enum ExaminationType {
	// TODO: neco...
	UNSPEC("nespecif."),
	USNI("ustni"), 
	KRCNI("krci"), 
	UROLOGICKE("urologicke"), 
	ORNITOLOGICKE("ornitologicke"), 
	CEVNI("cevni");
	
	private final String label;

	private ExaminationType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
