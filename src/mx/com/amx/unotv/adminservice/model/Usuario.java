package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the uno_c_usuarios database table.
 * 
 */
@Entity
@Table(name="uno_c_usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_USUARIO")
	private String fcIdUsuario;

	@Column(name="FC_NOMBRE")
	private String fcNombre;

	@Column(name="FD_FECHA_REGISTRO")
	private Timestamp fdFechaRegistro;

	@Column(name="FI_ESTATUS")
	private int fiEstatus;

	//bi-directional many-to-one association to HNota
	@OneToMany(mappedBy="unoCUsuario")
	private List<HNota> unoHNotas;

	//bi-directional many-to-one association to NNota
	@OneToMany(mappedBy="unoCUsuario")
	private List<NNota> unoNNotas;

	//bi-directional many-to-one association to VNota
	@OneToMany(mappedBy="unoCUsuario")
	private List<VNota> unoVNotas;

	public Usuario() {
	}

	public String getFcIdUsuario() {
		return this.fcIdUsuario;
	}

	public void setFcIdUsuario(String fcIdUsuario) {
		this.fcIdUsuario = fcIdUsuario;
	}

	public String getFcNombre() {
		return this.fcNombre;
	}

	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}

	public Timestamp getFdFechaRegistro() {
		return this.fdFechaRegistro;
	}

	public void setFdFechaRegistro(Timestamp fdFechaRegistro) {
		this.fdFechaRegistro = fdFechaRegistro;
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
		unoHNota.setUnoCUsuario(this);

		return unoHNota;
	}

	public HNota removeUnoHNota(HNota unoHNota) {
		getUnoHNotas().remove(unoHNota);
		unoHNota.setUnoCUsuario(null);

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
		unoNNota.setUnoCUsuario(this);

		return unoNNota;
	}

	public NNota removeUnoNNota(NNota unoNNota) {
		getUnoNNotas().remove(unoNNota);
		unoNNota.setUnoCUsuario(null);

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
		unoVNota.setUnoCUsuario(this);

		return unoVNota;
	}

	public VNota removeUnoVNota(VNota unoVNota) {
		getUnoVNotas().remove(unoVNota);
		unoVNota.setUnoCUsuario(null);

		return unoVNota;
	}

}