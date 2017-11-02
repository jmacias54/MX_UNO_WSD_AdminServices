package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;

import java.sql.Timestamp;


/**
 * The persistent class for the uno_n_nota database table.
 * 
 */

public class NNota implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fcIdContenido;

	private String clGaleria;

	private String clRtfContenido;

	private String fcAlternativeTextOoyala;

	private String fcContentIdOoyala;

	private String fcDescripcion;

	private String fcDurationOoyala;

	private String fcEscribio;

	private String fcFileSizeOoyala;

	private String fcFriendlyUrl;

	private String fcFuente;

	private String fcImagen;

	private String fcKeywords;

	private String fcLugar;

	private String fcPcodeOoyala;

	private String fcPlayerIdOoyala;

	private String fcSourceOoyala;

	private String fcTitulo;

	private String fcVideoYoutube;

	private Timestamp fdFechaModificacion;

	private Timestamp fdFechaPublicacion;

	private int fiBanInfinitoHome;

	private int fiBanMsn;

	private int fiBanOtros;
	private String fcIdCategoria;

	private String fcIdEstatus;

	private String fcIdTipoNota;

	private String fcIdUsuario;

	public NNota() {
	}

	public String getFcIdContenido() {
		return this.fcIdContenido;
	}

	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	public String getClGaleria() {
		return this.clGaleria;
	}

	public void setClGaleria(String clGaleria) {
		this.clGaleria = clGaleria;
	}

	public String getClRtfContenido() {
		return this.clRtfContenido;
	}

	public void setClRtfContenido(String clRtfContenido) {
		this.clRtfContenido = clRtfContenido;
	}

	public String getFcAlternativeTextOoyala() {
		return this.fcAlternativeTextOoyala;
	}

	public void setFcAlternativeTextOoyala(String fcAlternativeTextOoyala) {
		this.fcAlternativeTextOoyala = fcAlternativeTextOoyala;
	}

	public String getFcContentIdOoyala() {
		return this.fcContentIdOoyala;
	}

	public void setFcContentIdOoyala(String fcContentIdOoyala) {
		this.fcContentIdOoyala = fcContentIdOoyala;
	}

	public String getFcDescripcion() {
		return this.fcDescripcion;
	}

	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
	}

	public String getFcDurationOoyala() {
		return this.fcDurationOoyala;
	}

	public void setFcDurationOoyala(String fcDurationOoyala) {
		this.fcDurationOoyala = fcDurationOoyala;
	}

	public String getFcEscribio() {
		return this.fcEscribio;
	}

	public void setFcEscribio(String fcEscribio) {
		this.fcEscribio = fcEscribio;
	}

	public String getFcFileSizeOoyala() {
		return this.fcFileSizeOoyala;
	}

	public void setFcFileSizeOoyala(String fcFileSizeOoyala) {
		this.fcFileSizeOoyala = fcFileSizeOoyala;
	}

	public String getFcFriendlyUrl() {
		return this.fcFriendlyUrl;
	}

	public void setFcFriendlyUrl(String fcFriendlyUrl) {
		this.fcFriendlyUrl = fcFriendlyUrl;
	}

	public String getFcFuente() {
		return this.fcFuente;
	}

	public void setFcFuente(String fcFuente) {
		this.fcFuente = fcFuente;
	}

	public String getFcImagen() {
		return this.fcImagen;
	}

	public void setFcImagen(String fcImagen) {
		this.fcImagen = fcImagen;
	}

	public String getFcKeywords() {
		return this.fcKeywords;
	}

	public void setFcKeywords(String fcKeywords) {
		this.fcKeywords = fcKeywords;
	}

	public String getFcLugar() {
		return this.fcLugar;
	}

	public void setFcLugar(String fcLugar) {
		this.fcLugar = fcLugar;
	}

	public String getFcPcodeOoyala() {
		return this.fcPcodeOoyala;
	}

	public void setFcPcodeOoyala(String fcPcodeOoyala) {
		this.fcPcodeOoyala = fcPcodeOoyala;
	}

	public String getFcPlayerIdOoyala() {
		return this.fcPlayerIdOoyala;
	}

	public void setFcPlayerIdOoyala(String fcPlayerIdOoyala) {
		this.fcPlayerIdOoyala = fcPlayerIdOoyala;
	}

	public String getFcSourceOoyala() {
		return this.fcSourceOoyala;
	}

	public void setFcSourceOoyala(String fcSourceOoyala) {
		this.fcSourceOoyala = fcSourceOoyala;
	}

	public String getFcTitulo() {
		return this.fcTitulo;
	}

	public void setFcTitulo(String fcTitulo) {
		this.fcTitulo = fcTitulo;
	}

	public String getFcVideoYoutube() {
		return this.fcVideoYoutube;
	}

	public void setFcVideoYoutube(String fcVideoYoutube) {
		this.fcVideoYoutube = fcVideoYoutube;
	}

	public Timestamp getFdFechaModificacion() {
		return this.fdFechaModificacion;
	}

	public void setFdFechaModificacion(Timestamp fdFechaModificacion) {
		this.fdFechaModificacion = fdFechaModificacion;
	}

	public Timestamp getFdFechaPublicacion() {
		return this.fdFechaPublicacion;
	}

	public void setFdFechaPublicacion(Timestamp fdFechaPublicacion) {
		this.fdFechaPublicacion = fdFechaPublicacion;
	}

	public int getFiBanInfinitoHome() {
		return this.fiBanInfinitoHome;
	}

	public void setFiBanInfinitoHome(int fiBanInfinitoHome) {
		this.fiBanInfinitoHome = fiBanInfinitoHome;
	}

	public int getFiBanMsn() {
		return this.fiBanMsn;
	}

	public void setFiBanMsn(int fiBanMsn) {
		this.fiBanMsn = fiBanMsn;
	}

	public int getFiBanOtros() {
		return this.fiBanOtros;
	}

	public void setFiBanOtros(int fiBanOtros) {
		this.fiBanOtros = fiBanOtros;
	}

	public String getFcIdCategoria() {
		return fcIdCategoria;
	}

	public void setFcIdCategoria(String fcIdCategoria) {
		this.fcIdCategoria = fcIdCategoria;
	}

	public String getFcIdEstatus() {
		return fcIdEstatus;
	}

	public void setFcIdEstatus(String fcIdEstatus) {
		this.fcIdEstatus = fcIdEstatus;
	}

	public String getFcIdTipoNota() {
		return fcIdTipoNota;
	}

	public void setFcIdTipoNota(String fcIdTipoNota) {
		this.fcIdTipoNota = fcIdTipoNota;
	}

	public String getFcIdUsuario() {
		return fcIdUsuario;
	}

	public void setFcIdUsuario(String fcIdUsuario) {
		this.fcIdUsuario = fcIdUsuario;
	}

	

}