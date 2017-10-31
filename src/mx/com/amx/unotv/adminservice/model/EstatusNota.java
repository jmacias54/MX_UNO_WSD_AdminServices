package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uno_c_estatus_nota database table.
 * 
 */
@Entity
@Table(name="uno_c_estatus_nota")
@NamedQuery(name="EstatusNota.findAll", query="SELECT e FROM EstatusNota e")
public class EstatusNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_ESTATUS")
	private String fcIdEstatus;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	//bi-directional many-to-one association to HNota
	@OneToMany(mappedBy="unoCEstatusNota")
	private List<HNota> unoHNotas;

	//bi-directional many-to-one association to NNota
	@OneToMany(mappedBy="unoCEstatusNota")
	private List<NNota> unoNNotas;

	//bi-directional many-to-one association to VNota
	@OneToMany(mappedBy="unoCEstatusNota")
	private List<VNota> unoVNotas;

	public EstatusNota() {
	}

	public String getFcIdEstatus() {
		return this.fcIdEstatus;
	}

	public void setFcIdEstatus(String fcIdEstatus) {
		this.fcIdEstatus = fcIdEstatus;
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
		unoHNota.setUnoCEstatusNota(this);

		return unoHNota;
	}

	public HNota removeUnoHNota(HNota unoHNota) {
		getUnoHNotas().remove(unoHNota);
		unoHNota.setUnoCEstatusNota(null);

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
		unoNNota.setUnoCEstatusNota(this);

		return unoNNota;
	}

	public NNota removeUnoNNota(NNota unoNNota) {
		getUnoNNotas().remove(unoNNota);
		unoNNota.setUnoCEstatusNota(null);

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
		unoVNota.setUnoCEstatusNota(this);

		return unoVNota;
	}

	public VNota removeUnoVNota(VNota unoVNota) {
		getUnoVNotas().remove(unoVNota);
		unoVNota.setUnoCEstatusNota(null);

		return unoVNota;
	}

}