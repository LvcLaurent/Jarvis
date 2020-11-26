/**
 * 
 */
package fr.lsi.jarvis.domain.localizer;

import org.springframework.http.HttpStatus;

/**
 * Location service constant
 * 
 * @author Laurent SION
 *
 */
@SuppressWarnings("nls")
public interface LocalizerConstant {
	
	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE = "bad request";
	
	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO = "";
	
	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final Integer RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE = Integer.valueOf(400);
	
	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final HttpStatus RETURN_CONSTRUTOR_LOCALIZER_ERROR_STATUS = HttpStatus.BAD_REQUEST;
	
	
}
