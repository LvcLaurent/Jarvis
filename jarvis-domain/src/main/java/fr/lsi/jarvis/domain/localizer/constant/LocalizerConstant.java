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

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_JEEDOM_LOCALIZER_ERROR_MESSAGE = "Erreur sur la mise à jour dans jeedom";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_JEEDOM_LOCALIZER_ERROR_INFO = "Vérifier les ID_CMD de Jeedom";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final Integer RETURN_JEEDOM_LOCALIZER_ERROR_CODE = Integer.valueOf(1003);

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_MESSAGE = "Erreur pendant l'appel de jeedom";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_INFO = "une erreur technique est survenu";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final Integer RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_CODE = Integer.valueOf(1004);

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_USERNAME_CONNU_LOCALIZER_ERROR_MESSAGE = "Cette utilisateur est déjà connu en base";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_USERNAME_CONNU_LOCALIZER_ERROR_INFO = "";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final Integer RETURN_USERNAME_CONNU_LOCALIZER_ERROR_CODE = Integer.valueOf(1005);

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_LOCATION_INCONNU_LOCALIZER_ERROR_MESSAGE = "La location n'est pas connu";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final String RETURN_LOCATION_INCONNU_LOCALIZER_ERROR_INFO = "";

	/**
	 * message in case of error on the construction of the LocationEntity object
	 */
	final Integer RETURN_LOCATION_INCONNU_LOCALIZER_ERROR_CODE = Integer.valueOf(1006);

}
