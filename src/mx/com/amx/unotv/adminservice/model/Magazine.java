package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uno_c_magazine database table.
 * 
 */
@Entity
@Table(name="uno_c_magazine")
@NamedQuery(name="Magazine.findAll", query="SELECT m FROM Magazine m")
public class Magazine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_MAGAZINE")
	private int fcIdMagazine;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	@Column(name="FI_REGISTRIS")
	private int fiRegistris;

	//bi-directional many-to-many association to NNota
	@ManyToMany
	@JoinTable(
		name="uno_i_magazine_nota"
		, joinColumns={
			@JoinColumn(name="FC_ID_MAGAZINE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FC_ID_CONTENIDO")
			}
		)
	private List<NNota> unoNNotas;

	public Magazine() {
	}

	public int getFcIdMagazine() {
		return this.fcIdMagazine;
	}

	public void setFcIdMagazine(int fcIdMagazine) {
		this.fcIdMagazine = fcIdMagazine;
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

	public int getFiRegistris() {
		return this.fiRegistris;
	}

	public void setFiRegistris(int fiRegistris) {
		this.fiRegistris = fiRegistris;
	}

	public List<NNota> getUnoNNotas() {
		return this.unoNNotas;
	}

	public void setUnoNNotas(List<NNota> unoNNotas) {
		this.unoNNotas = unoNNotas;
	}

}