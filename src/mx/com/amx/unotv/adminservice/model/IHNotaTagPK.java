package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the uno_i_h_nota_tags database table.
 * 
 */
@Embeddable
public class IHNotaTagPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="FC_ID_CONTENIDO", insertable=false, updatable=false)
	private String fcIdContenido;

	@Column(name="FC_ID_TAG", insertable=false, updatable=false)
	private String fcIdTag;

	public IHNotaTagPK() {
	}
	public String getFcIdContenido() {
		return this.fcIdContenido;
	}
	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}
	public String getFcIdTag() {
		return this.fcIdTag;
	}
	public void setFcIdTag(String fcIdTag) {
		this.fcIdTag = fcIdTag;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IHNotaTagPK)) {
			return false;
		}
		IHNotaTagPK castOther = (IHNotaTagPK)other;
		return 
			this.fcIdContenido.equals(castOther.fcIdContenido)
			&& this.fcIdTag.equals(castOther.fcIdTag);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.fcIdContenido.hashCode();
		hash = hash * prime + this.fcIdTag.hashCode();
		
		return hash;
	}
}