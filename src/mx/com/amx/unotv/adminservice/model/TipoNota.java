package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uno_c_tipo_nota database table.
 * 
 */
@Entity
@Table(name="uno_c_tipo_nota")
@NamedQuery(name="TipoNota.findAll", query="SELECT t FROM TipoNota t")
public class TipoNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_TIPO_NOTA")
	private String fcIdTipoNota;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	//bi-directional many-to-one association to HNota
	@OneToMany(mappedBy="unoCTipoNota")
	private List<HNota> unoHNotas;

	//bi-directional many-to-one association to NNota
	@OneToMany(mappedBy="unoCTipoNota")
	private List<NNota> unoNNotas;

	//bi-directional many-to-one association to VNota
	@OneToMany(mappedBy="unoCTipoNota")
	private List<VNota> unoVNotas;

	public TipoNota() {
	}

	public String getFcIdTipoNota() {
		return this.fcIdTipoNota;
	}

	public void setFcIdTipoNota(String fcIdTipoNota) {
		this.fcIdTipoNota = fcIdTipoNota;
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

	public HNota addUnoHNota(HNota unoHNota) {
		getUnoHNotas().add(unoHNota);
		unoHNota.setUnoCTipoNota(this);

		return unoHNota;
	}

	public HNota removeUnoHNota(HNota unoHNota) {
		getUnoHNotas().remove(unoHNota);
		unoHNota.setUnoCTipoNota(null);

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
		unoNNota.setUnoCTipoNota(this);

		return unoNNota;
	}

	public NNota removeUnoNNota(NNota unoNNota) {
		getUnoNNotas().remove(unoNNota);
		unoNNota.setUnoCTipoNota(null);

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
		unoVNota.setUnoCTipoNota(this);

		return unoVNota;
	}

	public VNota removeUnoVNota(VNota unoVNota) {
		getUnoVNotas().remove(unoVNota);
		unoVNota.setUnoCTipoNota(null);

		return unoVNota;
	}

}