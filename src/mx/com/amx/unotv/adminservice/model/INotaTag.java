package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uno_i_nota_tags database table.
 * 
 */
@Entity
@Table(name="uno_i_nota_tags")
@NamedQuery(name="INotaTag.findAll", query="SELECT i FROM INotaTag i")
public class INotaTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private INotaTagPK id;


	@JoinColumn(name="FC_ID_CONTENIDO")
	private NNota unoNNota;

	public INotaTag() {
	}

	public INotaTagPK getId() {
		return this.id;
	}

	public void setId(INotaTagPK id) {
		this.id = id;
	}

	public NNota getUnoNNota() {
		return this.unoNNota;
	}

	public void setUnoNNota(NNota unoNNota) {
		this.unoNNota = unoNNota;
	}


}