/**
 * 
 */
package fr.lsi.jarvis.domain.exception;

import org.springframework.http.HttpStatus;

import fr.lsi.jarvis.domain.generic.GenericConstant;

/**
 * Class mère des exceptions
 * 
 * @author Laurent SION
 *
 */
public class JarvisException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7694757065622241716L;
	
	/**
	 * Message pour le retour 
	 */
	private String message;	

	/**
	 * Status du message de retour
	 */
	private HttpStatus status; 
	
	/**
	 * Information pour le retour
	 */
	private String information;
	
	/**
	 * Code retour
	 */
	private Integer code;
	
	/**
	 * Constructor
	 */
	public JarvisException() {
		message = GenericConstant.RETURN_GENERIC_ERROR_MESSAGE;
		code = GenericConstant.RETURN_GENERIC_ERROR_CODE;
		information = GenericConstant.RETURN_GENERIC_ERROR_INFO;
		status = GenericConstant.RETURN_GENERIC_ERROR_STATUT;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public final HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the information
	 */
	public final String getInformation() {
		return information;
	}

	/**
	 * @param information the information to set
	 */
	public final void setInformation(String information) {
		this.information = information;
	}

	/**
	 * @return the code
	 */
	public final Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public final void setCode(Integer code) {
		this.code = code;
	}

}
