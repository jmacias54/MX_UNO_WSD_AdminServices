package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uno_c_seccion database table.
 * 
 */
@Entity
@Table(name="uno_c_seccion")
@NamedQuery(name="Seccion.findAll", query="SELECT s FROM Seccion s")
public class Seccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_SECCION")
	private String fcIdSeccion;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FC_FRIENDLY_URL")
	private String fcFriendlyUrl;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="unoCSeccion")
	private List<Categoria> unoCCategorias;

	public Seccion() {
	}

	public String getFcIdSeccion() {
		return this.fcIdSeccion;
	}

	public void setFcIdSeccion(String fcIdSeccion) {
		this.fcIdSeccion = fcIdSeccion;
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

	public int getFiEstatus() {
		return this.fiEstatus;
	}

	public void setFiEstatus(int fiEstatus) {
		this.fiEstatus = fiEstatus;
	}

	public List<Categoria> getUnoCCategorias() {
		return this.unoCCategorias;
	}

	public void setUnoCCategorias(List<Categoria> unoCCategorias) {
		this.unoCCategorias = unoCCategorias;
	}

	public Categoria addUnoCCategoria(Categoria unoCCategoria) {
		getUnoCCategorias().add(unoCCategoria);
		unoCCategoria.setUnoCSeccion(this);

		return unoCCategoria;
	}

	public Categoria removeUnoCCategoria(Categoria unoCCategoria) {
		getUnoCCategorias().remove(unoCCategoria);
		unoCCategoria.setUnoCSeccion(null);

		return unoCCategoria;
	}

}