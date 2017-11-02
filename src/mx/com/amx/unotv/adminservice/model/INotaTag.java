package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;

/**
 * The persistent class for the uno_i_nota_tags database table.
 * 
 */

public class INotaTag implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fcIdContenido;

	private String fcIdTag;

	public INotaTag() {
	}

	public String getFcIdContenido() {
		return fcIdContenido;
	}

	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	public String getFcIdTag() {
		return fcIdTag;
	}

	public void setFcIdTag(String fcIdTag) {
		this.fcIdTag = fcIdTag;
	}

}