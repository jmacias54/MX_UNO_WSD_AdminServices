package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;



/**
 * The persistent class for the uno_c_estatus_nota database table.
 * 
 */

public class EstatusNota implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fcIdEstatus;

	private String fcDescripcion;

	private int fiEstatus;

	public EstatusNota() {
	}

	public String getFcIdEstatus() {
		return this.fcIdEstatus;
	}

	public void setFcIdEstatus(String fcIdEstatus) {
		this.fcIdEstatus = fcIdEstatus;
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