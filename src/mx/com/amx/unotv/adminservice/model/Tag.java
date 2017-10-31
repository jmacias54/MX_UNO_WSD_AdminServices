package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uno_c_tags database table.
 * 
 */
@Entity
@Table(name="uno_c_tags")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_TAG")
	private String fcIdTag;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	//bi-directional many-to-many association to HNota
	@ManyToMany
	@JoinTable(
		name="uno_i_h_nota_tags"
		, joinColumns={
			@JoinColumn(name="FC_ID_TAG")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FC_ID_CONTENIDO")
			}
		)
	private List<HNota> unoHNotas;

	//bi-directional many-to-many association to NNota
	@ManyToMany
	@JoinTable(
		name="uno_i_nota_tags"
		, joinColumns={
			@JoinColumn(name="FC_ID_TAG")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FC_ID_CONTENIDO")
			}
		)
	private List<NNota> unoNNotas;

	//bi-directional many-to-one association to IHNotaTag
	@OneToMany(mappedBy="unoCTag")
	private List<IHNotaTag> unoIHNotaTags;

	public Tag() {
	}

	public String getFcIdTag() {
		return this.fcIdTag;
	}

	public void setFcIdTag(String fcIdTag) {
		this.fcIdTag = fcIdTag;
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

	public List<HNota> getUnoHNotas() {
		return this.unoHNotas;
	}

	public void setUnoHNotas(List<HNota> unoHNotas) {
		this.unoHNotas = unoHNotas;
	}

	public List<NNota> getUnoNNotas() {
		return this.unoNNotas;
	}

	public void setUnoNNotas(List<NNota> unoNNotas) {
		this.unoNNotas = unoNNotas;
	}

	public List<IHNotaTag> getUnoIHNotaTags() {
		return this.unoIHNotaTags;
	}

	public void setUnoIHNotaTags(List<IHNotaTag> unoIHNotaTags) {
		this.unoIHNotaTags = unoIHNotaTags;
	}

	public IHNotaTag addUnoIHNotaTag(IHNotaTag unoIHNotaTag) {
		getUnoIHNotaTags().add(unoIHNotaTag);
		unoIHNotaTag.setUnoCTag(this);

		return unoIHNotaTag;
	}

	public IHNotaTag removeUnoIHNotaTag(IHNotaTag unoIHNotaTag) {
		getUnoIHNotaTags().remove(unoIHNotaTag);
		unoIHNotaTag.setUnoCTag(null);

		return unoIHNotaTag;
	}

}