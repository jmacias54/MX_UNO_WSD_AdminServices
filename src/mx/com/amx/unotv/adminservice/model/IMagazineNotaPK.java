package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the uno_i_magazine_nota database table.
 * 
 */
@Embeddable
public class IMagazineNotaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FC_ID_MAGAZINE", insertable=false, updatable=false)
	private int fcIdMagazine;

	@Column(name="FC_ID_CONTENIDO", insertable=false, updatable=false)
	private String fcIdContenido;

	public IMagazineNotaPK() {
	}
	public int getFcIdMagazine() {
		return this.fcIdMagazine;
	}
	public void setFcIdMagazine(int fcIdMagazine) {
		this.fcIdMagazine = fcIdMagazine;
	}
	public String getFcIdContenido() {
		return this.fcIdContenido;
	}
	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IMagazineNotaPK)) {
			return false;
		}
		IMagazineNotaPK castOther = (IMagazineNotaPK)other;
		return 
			(this.fcIdMagazine == castOther.fcIdMagazine)
			&& this.fcIdContenido.equals(castOther.fcIdContenido);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fcIdMagazine;
		hash = hash * prime + this.fcIdContenido.hashCode();
		
		return hash;
	}
}