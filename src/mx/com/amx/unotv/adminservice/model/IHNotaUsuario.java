/**
 * 
 */
package mx.com.amx.unotv.adminservice.model;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class IHNotaUsuario {

	private String fcIdUsuario;
	private String fcIdContenido;
	private String fdFechaModificacion;

	/**
	 * @param fcIdUsuario
	 * @param fcIdContenido
	 * @param fdFechaModificacion
	 */
	public IHNotaUsuario(String fcIdUsuario, String fcIdContenido, String fdFechaModificacion) {
		super();
		this.fcIdUsuario = fcIdUsuario;
		this.fcIdContenido = fcIdContenido;
		this.fdFechaModificacion = fdFechaModificacion;
	}

	/**
	 * 
	 */
	public IHNotaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFcIdUsuario() {
		return fcIdUsuario;
	}

	public void setFcIdUsuario(String fcIdUsuario) {
		this.fcIdUsuario = fcIdUsuario;
	}

	public String getFcIdContenido() {
		return fcIdContenido;
	}

	public void setFcIdContenido(String fcIdContenido) {
		this.fcIdContenido = fcIdContenido;
	}

	public String getFdFechaModificacion() {
		return fdFechaModificacion;
	}

	public void setFdFechaModificacion(String fdFechaModificacion) {
		this.fdFechaModificacion = fdFechaModificacion;
	}

}
