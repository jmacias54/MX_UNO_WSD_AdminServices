/**
 * 
 */
package mx.com.amx.unotv.adminservice.bo.exception;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class NNotaBOException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new categoria BO exception.
	 */
	public NNotaBOException() {
		super();
	}

	/**
	 * Instantiates a new categoria BO exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public NNotaBOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new categoria BO exception.
	 *
	 * @param message
	 *            the message
	 */
	public NNotaBOException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new categoria BO exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public NNotaBOException(Throwable cause) {
		super(cause);
	}

}
