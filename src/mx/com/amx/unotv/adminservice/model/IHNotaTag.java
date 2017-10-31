package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the uno_i_h_nota_tags database table.
 * 
 */
@Entity
@Table(name="uno_i_h_nota_tags")
@NamedQuery(name="IHNotaTag.findAll", query="SELECT i FROM IHNotaTag i")
public class IHNotaTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IHNotaTagPK id;

	
	@JoinColumn(name="FC_ID_TAG")
	private Tag unoCTag;

	public IHNotaTag() {
	}

	public IHNotaTagPK getId() {
		return this.id;
	}

	public void setId(IHNotaTagPK id) {
		this.id = id;
	}

	public Tag getUnoCTag() {
		return this.unoCTag;
	}

	public void setUnoCTag(Tag unoCTag) {
		this.unoCTag = unoCTag;
	}

}