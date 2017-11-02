package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;


/**
 * The persistent class for the uno_c_seccion database table.
 * 
 */

public class Seccion implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fcIdSeccion;
	private String fcDescripcion;
	private String fcFriendlyUrl;
	private int fiEstatus;

	public Seccion() {
	}

	public String getFcIdSeccion() {
		return this.fcIdSeccion;
	}

	public void setFcIdSeccion(String fcIdSeccion) {
		this.fcIdSeccion = fcIdSeccion;
	}

	public String getFcDescripcion() {
		return this.fcDescripcion;
	}

	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
	}

	public String getFcFriendlyUrl() {
		return this.fcFriendlyUrl;
	}

	public void setFcFriendlyUrl(String fcFriendlyUrl) {
		this.fcFriendlyUrl = fcFriendlyUrl;
	}

	public int getFiEstatus() {
		return this.fiEstatus;
	}

	public void setFiEstatus(int fiEstatus) {
		this.fiEstatus = fiEstatus;
	}
	



}