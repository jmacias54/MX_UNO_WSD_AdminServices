package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;



public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;


	private String fcIdCategoria;

	
	private String fcDescripcion;

	
	private String fcFriendlyUrl;

	
	private String fcRutaDfp;

	
	private Integer fiEstatus;

	
	private String fiRegistros;

	
	private String fcIdSeccion;

	

	public Categoria() {
	}

	public String getFcIdCategoria() {
		return this.fcIdCategoria;
	}

	public void setFcIdCategoria(String fcIdCategoria) {
		this.fcIdCategoria = fcIdCategoria;
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

	public String getFcRutaDfp() {
		return this.fcRutaDfp;
	}

	public void setFcRutaDfp(String fcRutaDfp) {
		this.fcRutaDfp = fcRutaDfp;
	}

	public Integer getFiEstatus() {
		return this.fiEstatus;
	}

	public void setFiEstatus(int fiEstatus) {
		this.fiEstatus = fiEstatus;
	}

	public String getFiRegistros() {
		return this.fiRegistros;
	}

	public void setFiRegistros(String fiRegistros) {
		this.fiRegistros = fiRegistros;
	}

	public String getFcIdSeccion() {
		return fcIdSeccion;
	}

	public void setFcIdSeccion(String fcIdSeccion) {
		this.fcIdSeccion = fcIdSeccion;
	}

	
	
	
}