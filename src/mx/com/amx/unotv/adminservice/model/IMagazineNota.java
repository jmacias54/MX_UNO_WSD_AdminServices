package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uno_i_magazine_nota database table.
 * 
 */
@Entity
@Table(name="uno_i_magazine_nota")
@NamedQuery(name="IMagazineNota.findAll", query="SELECT i FROM IMagazineNota i")
public class IMagazineNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IMagazineNotaPK id;

	@JoinColumn(name="FC_ID_CONTENIDO")
	private NNota unoNNota;

	public IMagazineNota() {
	}

	public IMagazineNotaPK getId() {
		return this.id;
	}

	public void setId(IMagazineNotaPK id) {
		this.id = id;
	}

	public NNota getUnoNNota() {
		return this.unoNNota;
	}

	public void setUnoNNota(NNota unoNNota) {
		this.unoNNota = unoNNota;
	}

}