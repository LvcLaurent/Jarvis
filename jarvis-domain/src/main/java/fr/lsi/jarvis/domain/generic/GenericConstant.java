/**
 * 
 */
package fr.lsi.jarvis.domain.generic;

import org.springframework.http.HttpStatus;

/**
 * Application constant
 * 
 * @author Laurent SION
 *
 */
@SuppressWarnings("nls")
public interface GenericConstant {

	/**
	 * message d'erreur du genericOut
	 */
	final String RETURN_GENERIC_ERROR_MESSAGE = "error";
	
	/**
	 * message d'erreur du genericOut
	 */
	final String RETURN_GENERIC_ERROR_INFO = "";
	
	/**
	 * code d'erreur du genericOut
	 */
	final Integer RETURN_GENERIC_ERROR_CODE = Integer.valueOf(500);
	
	/**
	 * Statut du genericOut
	 */
	final HttpStatus RETURN_GENERIC_ERROR_STATUT = HttpStatus.INTERNAL_SERVER_ERROR;

}
