package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;

import java.sql.Timestamp;



/**
 * The persistent class for the uno_c_usuarios database table.
 * 
 */

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;


	private String fcIdUsuario;


	private String fcNombre;

	
	private Timestamp fdFechaRegistro;


	private int fiEstatus;

	

	public Usuario() {
	}

	public String getFcIdUsuario() {
		return this.fcIdUsuario;
	}

	public void setFcIdUsuario(String fcIdUsuario) {
		this.fcIdUsuario = fcIdUsuario;
	}

	public String getFcNombre() {
		return this.fcNombre;
	}

	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}

	public Timestamp getFdFechaRegistro() {
		return this.fdFechaRegistro;
	}

	public void setFdFechaRegistro(Timestamp fdFechaRegistro) {
		this.fdFechaRegistro = fdFechaRegistro;
	}

	public int getFiEstatus() {
		return this.fiEstatus;
	}

	public void setFiEstatus(int fiEstatus) {
		this.fiEstatus = fiEstatus;
	}

	

}