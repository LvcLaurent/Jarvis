/**
 * 
 */
package fr.lsi.jarvis.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * For Functional exceptions
 * 
 * @author Laurent SION
 *
 */
public class JarvisFunctionalException extends JarvisException {
	
	/**
	 * ID class
	 */
	private static final long serialVersionUID = 5028656413507694340L;

	/**
	 * Constructor of a functional exception
	 * 
	 * @param status
	 * @param message
	 * @param information
	 * @param code
	 */
	public JarvisFunctionalException(final HttpStatus status, final String message, final String information, final Integer code) {
		this.setCode(code);
		this.setInformation(information);
		this.setMessage(message);
		this.setStatus(status);
	}

}
