package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uno_c_categoria database table.
 * 
 */
@Entity
@Table(name="uno_c_categoria")
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_CATEGORIA")
	private String fcIdCategoria;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FC_FRIENDLY_URL")
	private String fcFriendlyUrl;

	@Column(name="FC_RUTA_DFP")
	private String fcRutaDfp;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	@Column(name="FI_REGISTRIS")
	private int fiRegistris;

	//bi-directional many-to-one association to Seccion
	@ManyToOne
	@JoinColumn(name="FC_ID_SECCION")
	private Seccion unoCSeccion;

	//bi-directional many-to-one association to HNota
	@OneToMany(mappedBy="unoCCategoria")
	private List<HNota> unoHNotas;

	//bi-directional many-to-one association to NNota
	@OneToMany(mappedBy="unoCCategoria")
	private List<NNota> unoNNotas;

	//bi-directional many-to-one association to VNota
	@OneToMany(mappedBy="unoCCategoria")
	private List<VNota> unoVNotas;

	public Categoria() {
	}

	public String getFcIdCategoria() {
		return this.fcIdCategoria;
	}

	public void setFcIdCategoria(String fcIdCategoria) {
		this.fcIdCategoria = fcIdCategoria;
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

	public String getFcRutaDfp() {
		return this.fcRutaDfp;
	}

	public void setFcRutaDfp(String fcRutaDfp) {
		this.fcRutaDfp = fcRutaDfp;
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

	public Seccion getUnoCSeccion() {
		return this.unoCSeccion;
	}

	public void setUnoCSeccion(Seccion unoCSeccion) {
		this.unoCSeccion = unoCSeccion;
	}

	public List<HNota> getUnoHNotas() {
		return this.unoHNotas;
	}

	public void setUnoHNotas(List<HNota> unoHNotas) {
		this.unoHNotas = unoHNotas;
	}

	public HNota addUnoHNota(HNota unoHNota) {
		getUnoHNotas().add(unoHNota);
		unoHNota.setUnoCCategoria(this);

		return unoHNota;
	}

	public HNota removeUnoHNota(HNota unoHNota) {
		getUnoHNotas().remove(unoHNota);
		unoHNota.setUnoCCategoria(null);

		return unoHNota;
	}

	public List<NNota> getUnoNNotas() {
		return this.unoNNotas;
	}

	public void setUnoNNotas(List<NNota> unoNNotas) {
		this.unoNNotas = unoNNotas;
	}

	public NNota addUnoNNota(NNota unoNNota) {
		getUnoNNotas().add(unoNNota);
		unoNNota.setUnoCCategoria(this);

		return unoNNota;
	}

	public NNota removeUnoNNota(NNota unoNNota) {
		getUnoNNotas().remove(unoNNota);
		unoNNota.setUnoCCategoria(null);

		return unoNNota;
	}

	public List<VNota> getUnoVNotas() {
		return this.unoVNotas;
	}

	public void setUnoVNotas(List<VNota> unoVNotas) {
		this.unoVNotas = unoVNotas;
	}

	public VNota addUnoVNota(VNota unoVNota) {
		getUnoVNotas().add(unoVNota);
		unoVNota.setUnoCCategoria(this);

		return unoVNota;
	}

	public VNota removeUnoVNota(VNota unoVNota) {
		getUnoVNotas().remove(unoVNota);
		unoVNota.setUnoCCategoria(null);

		return unoVNota;
	}

}