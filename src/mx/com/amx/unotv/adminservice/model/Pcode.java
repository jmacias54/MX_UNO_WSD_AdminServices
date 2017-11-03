package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;

public class Pcode implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String fcIdPcode;

	
	private String fcPcode;


	private int fiEstatus;

	public Pcode() {
	}

	public String getFcIdPcode() {
		return this.fcIdPcode;
	}

	public void setFcIdPcode(String fcIdPcode) {
		this.fcIdPcode = fcIdPcode;
	}

	public String getFcPcode() {
		return this.fcPcode;
	}

	public void setFcPcode(String fcPcode) {
		this.fcPcode = fcPcode;
	}

	public int getFiEstatus() {
		return this.fiEstatus;
	}

	public void setFiEstatus(int fiEstatus) {
		this.fiEstatus = fiEstatus;
	}

}
