package mx.com.amx.unotv.adminservice.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the uno_n_nota database table.
 * 
 */
@Entity
@Table(name="uno_n_nota")
@NamedQuery(name="NNota.findAll", query="SELECT n FROM NNota n")
public class NNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FC_ID_CONTENIDO", insertable = true, updatable = false)
	private String fcIdContenido;

	@Lob
	@Column(name="CL_GALERIA")
	private String clGaleria;

	@Lob
	@Column(name="CL_RTF_CONTENIDO")
	private String clRtfContenido;

	@Column(name="FC_ALTERNATIVE_TEXT_OOYALA")
	private String fcAlternativeTextOoyala;

	@Column(name="FC_CONTENT_ID_OOYALA")
	private String fcContentIdOoyala;

	@Column(name="FC_DESCRIPCION")
	private String fcDescripcion;

	@Column(name="FC_DURATION_OOYALA")
	private String fcDurationOoyala;

	@Column(name="FC_ESCRIBIO")
	private String fcEscribio;

	@Column(name="FC_FILE_SIZE_OOYALA")
	private String fcFileSizeOoyala;

	@Column(name="FC_FRIENDLY_URL")
	private String fcFriendlyUrl;

	@Column(name="FC_FUENTE")
	private String fcFuente;

	@Column(name="FC_IMAGEN")
	private String fcImagen;

	@Column(name="FC_KEYWORDS")
	private String fcKeywords;

	@Column(name="FC_LUGAR")
	private String fcLugar;

	@Column(name="FC_PCODE_OOYALA")
	private String fcPcodeOoyala;

	@Column(name="FC_PLAYER_ID_OOYALA")
	private String fcPlayerIdOoyala;

	@Column(name="FC_SOURCE_OOYALA")
	private String fcSourceOoyala;

	@Column(name="FC_TITULO")
	private String fcTitulo;

	@Column(name="FC_VIDEO_YOUTUBE")
	private String fcVideoYoutube;

	@Column(name="FD_FECHA_MODIFICACION")
	private Timestamp fdFechaModificacion;

	@Column(name="FD_FECHA_PUBLICACION")
	private Timestamp fdFechaPublicacion;

	@Column(name="FI_BAN_INFINITO_HOME")
	private int fiBanInfinitoHome;

	@Column(name="FI_BAN_MSN")
	private int fiBanMsn;

	@Column(name="FI_BAN_OTROS")
	private int fiBanOtros;

	//bi-directional many-to-many association to Magazine
	@ManyToMany(mappedBy="unoNNotas")
	private List<Magazine> unoCMagazines;

	//bi-directional many-to-many association to Tag
	@ManyToMany(mappedBy="unoNNotas")
	private List<Tag> unoCTags;

	//bi-directional many-to-one association to IMagazineNota
	@OneToMany(mappedBy="unoNNota")
	private List<IMagazineNota> unoIMagazineNotas;

	//bi-directional many-to-one association to INotaTag
	@OneToMany(mappedBy="unoNNota")
	private List<INotaTag> unoINotaTags;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="FC_ID_CATEGORIA")
	private Categoria unoCCategoria;

	//bi-directional many-to-one association to EstatusNota
	@ManyToOne
	@JoinColumn(name="FC_ID_ESTATUS")
	private EstatusNota unoCEstatusNota;

	//bi-directional many-to-one association to TipoNota
	@ManyToOne
	@JoinColumn(name="FC_ID_TIPO_NOTA")
	private TipoNota unoCTipoNota;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="FC_ID_USUARIO")
	private Usuario unoCUsuario;

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

	public List<Magazine> getUnoCMagazines() {
		return this.unoCMagazines;
	}

	public void setUnoCMagazines(List<Magazine> unoCMagazines) {
		this.unoCMagazines = unoCMagazines;
	}

	public List<Tag> getUnoCTags() {
		return this.unoCTags;
	}

	public void setUnoCTags(List<Tag> unoCTags) {
		this.unoCTags = unoCTags;
	}

	public List<IMagazineNota> getUnoIMagazineNotas() {
		return this.unoIMagazineNotas;
	}

	public void setUnoIMagazineNotas(List<IMagazineNota> unoIMagazineNotas) {
		this.unoIMagazineNotas = unoIMagazineNotas;
	}

	public IMagazineNota addUnoIMagazineNota(IMagazineNota unoIMagazineNota) {
		getUnoIMagazineNotas().add(unoIMagazineNota);
		unoIMagazineNota.setUnoNNota(this);

		return unoIMagazineNota;
	}

	public IMagazineNota removeUnoIMagazineNota(IMagazineNota unoIMagazineNota) {
		getUnoIMagazineNotas().remove(unoIMagazineNota);
		unoIMagazineNota.setUnoNNota(null);

		return unoIMagazineNota;
	}

	public List<INotaTag> getUnoINotaTags() {
		return this.unoINotaTags;
	}

	public void setUnoINotaTags(List<INotaTag> unoINotaTags) {
		this.unoINotaTags = unoINotaTags;
	}

	public INotaTag addUnoINotaTag(INotaTag unoINotaTag) {
		getUnoINotaTags().add(unoINotaTag);
		unoINotaTag.setUnoNNota(this);

		return unoINotaTag;
	}

	public INotaTag removeUnoINotaTag(INotaTag unoINotaTag) {
		getUnoINotaTags().remove(unoINotaTag);
		unoINotaTag.setUnoNNota(null);

		return unoINotaTag;
	}

	public Categoria getUnoCCategoria() {
		return this.unoCCategoria;
	}

	public void setUnoCCategoria(Categoria unoCCategoria) {
		this.unoCCategoria = unoCCategoria;
	}

	public EstatusNota getUnoCEstatusNota() {
		return this.unoCEstatusNota;
	}

	public void setUnoCEstatusNota(EstatusNota unoCEstatusNota) {
		this.unoCEstatusNota = unoCEstatusNota;
	}

	public TipoNota getUnoCTipoNota() {
		return this.unoCTipoNota;
	}

	public void setUnoCTipoNota(TipoNota unoCTipoNota) {
		this.unoCTipoNota = unoCTipoNota;
	}

	public Usuario getUnoCUsuario() {
		return this.unoCUsuario;
	}

	public void setUnoCUsuario(Usuario unoCUsuario) {
		this.unoCUsuario = unoCUsuario;
	}

}