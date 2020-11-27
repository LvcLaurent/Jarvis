/**
 *
 */
package fr.lsi.jarvis.domain.localizer.constant;

/**
 * Location service constant
 *
 * @author Laurent SION
 *
 */
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
	final Integer RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE = Integer.valueOf(1001);

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_GPS_LOCALIZER_ERROR_MESSAGE = "Coordonnée déjà connu";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_GPS_LOCALIZER_ERROR_INFO = "Les coordonnée sont déjà connu en base";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final Integer RETURN_GPS_LOCALIZER_ERROR_CODE = Integer.valueOf(1002);

}
