package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;



/**
 * The persistent class for the uno_c_tags database table.
 * 
 */

public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String fcIdTag;

	private String fcDescripcion;

	private int fiEstatus;

	public Tag() {
	}

	public String getFcIdTag() {
		return this.fcIdTag;
	}

	public void setFcIdTag(String fcIdTag) {
		this.fcIdTag = fcIdTag;
	}

	public String getFcDescripcion() {
		return this.fcDescripcion;
	}

	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
	}

	public int getFiEstatus() {
		return this.fiEstatus;
	}

	public void setFiEstatus(int fiEstatus) {
		this.fiEstatus = fiEstatus;
	}

	

}