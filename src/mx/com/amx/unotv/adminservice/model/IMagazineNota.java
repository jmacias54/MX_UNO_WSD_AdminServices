package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;

/**
 * The persistent class for the uno_i_magazine_nota database table.
 * 
 */

public class IMagazineNota implements Serializable {
	private static final long serialVersionUID = 1L;

	private int fcIdMagazine;

	private String fcIdContenido;
	private String fcUrlExterna;
	private Integer fiOrden;

	public IMagazineNota() {
	}

	public String getFcUrlExterna() {
		return fcUrlExterna;
	}

	public void setFcUrlExterna(String fcUrlExterna) {
		this.fcUrlExterna = fcUrlExterna;
	}

	public Integer getFiOrden() {
		return fiOrden;
	}

	public void setFiOrden(Integer fiOrden) {
		this.fiOrden = fiOrden;
	}

	public int getFcIdMagazine() {
		return fcIdMagazine;
	}

	public void setFcIdMagazine(int fcIdMagazine) {
		this.fcIdMagazine = fcIdMagazine;
	}

	public String getFcIdContenido() {
		return fcIdContenido;
	}

	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

}