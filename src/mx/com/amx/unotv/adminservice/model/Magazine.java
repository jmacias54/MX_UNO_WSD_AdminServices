package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;


/**
 * The persistent class for the uno_c_magazine database table.
 * 
 */

public class Magazine implements Serializable {
	private static final long serialVersionUID = 1L;

	private int fcIdMagazine;
	private String fcDescripcion;
	private int fiRegistris;
	private int fiEstatus;

	public Magazine() {
	}

	public int getFcIdMagazine() {
		return this.fcIdMagazine;
	}

	public void setFcIdMagazine(int fcIdMagazine) {
		this.fcIdMagazine = fcIdMagazine;
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

	public int getFiRegistris() {
		return this.fiRegistris;
	}

	public void setFiRegistris(int fiRegistris) {
		this.fiRegistris = fiRegistris;
	}

	

}