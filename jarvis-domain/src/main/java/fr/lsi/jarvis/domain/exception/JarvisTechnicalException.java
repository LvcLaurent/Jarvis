/**
 *
 */
package fr.lsi.jarvis.domain.exception;

/**
 * For Technical exceptions
 *
 * @author Laurent SION
 *
 */
public class JarvisTechnicalException extends JarvisException {

	/**
	 * ID class
	 */
	private static final long serialVersionUID = 5028656413507694340L;

	/**
	 * Constructor of a technical exception
	 *
	 * @param status
	 * @param message
	 * @param information
	 * @param code
	 */
	public JarvisTechnicalException(final String message, final String information, final Integer code) {
		this.setCode(code);
		this.setInformation(information);
		this.setMessage(message);
	}

}
