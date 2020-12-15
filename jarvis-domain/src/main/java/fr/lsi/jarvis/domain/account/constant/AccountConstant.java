package fr.lsi.jarvis.domain.account.constant;

/**
 * Account service constant
 *
 * @author Laurent SION
 *
 */
public interface AccountConstant {

	/**
	 * message if the email address is already known in the API
	 */
	final String RETURN_ACCOUNT_MAIL_ERROR_MESSAGE = "l'adresse mail est déjà connu dans l'api";

	/**
	 * info if the email address is already known in the API
	 */
	final String RETURN_ACCOUNT_MAIL_ERROR_INFO = "Modifier votre adresse mail";

	/**
	 * code if the email address is already known in the API
	 */
	final Integer RETURN_ACCOUNT_MAIL_ERROR_CODE = Integer.valueOf(2000);

	/**
	 * message if the phone address is already known in the API
	 */
	final String RETURN_ACCOUNT_PHONE_ERROR_MESSAGE = "le numéro de téléphone est déjà connu dans l'api";

	/**
	 * info if the email phone is already known in the API
	 */
	final String RETURN_ACCOUNT_PHONE_ERROR_INFO = "Modifier votre adresse numéro de téléphone";

	/**
	 * code if the email phone is already known in the API
	 */
	final Integer RETURN_ACCOUNT_PHONE_ERROR_CODE = Integer.valueOf(2004);

	/**
	 * message if the email login is already known in the API
	 */
	final String RETURN_ACCOUNT_LOGIN_ERROR_MESSAGE = "le login est déjà connu dans l'api";

	/**
	 * info if the email login is already known in the API
	 */
	final String RETURN_ACCOUNT_LOGIN_ERROR_INFO = "Modifier votre adresse login";

	/**
	 * code if the email login is already known in the API
	 */
	final Integer RETURN_ACCOUNT_LOGIN_ERROR_CODE = Integer.valueOf(2001);

	/**
	 * mapper null
	 */
	final String RETURN_MAPPER_MESSAGE = "le login est déjà connu dans l'api";

	/**
	 * info if the email login is already known in the API
	 */
	final String RETURN_MAPPER_INFO = "Modifier votre adresse login";

	/**
	 * code if the email login is already known in the API
	 */
	final Integer RETURN_MAPPER_CODE = Integer.valueOf(500);

	/**
	 * Message Password création au mauvais format
	 */
	final String RETURN_PASSWORD_CREATE_MESSAGE = "le mot de passe n'est pas au format attendu";

	/**
	 * info Password création au mauvais format
	 */
	final String RETURN_PASSWORD_CREATE_INFO = "Modifier votre mot de passe Majuscule, minuscule, chiffre, charactère spécial";

	/**
	 * code Password création au mauvais format
	 */
	final Integer RETURN_PASSWORD_CREATE_CODE = Integer.valueOf(2008);

	/**
	 * Message Phone création au mauvais format
	 */
	final String RETURN_PHONE_CREATE_MESSAGE = "le numéro de téléphone n'est pas au format attendu";

	/**
	 * info Phone création au mauvais format
	 */
	final String RETURN_PHONE_CREATE_INFO = "Modifier votre numéro de tel 0*********";

	/**
	 * code Phone création au mauvais format
	 */
	final Integer RETURN_PHONE_CREATE_CODE = Integer.valueOf(2003);

	/**
	 * Message login inconnu en base
	 */
	final String RETURN_LOGIN_UNKNOW_MESSAGE = "le login n'est pas connu en base";

	/**
	 * info login inconnu en base
	 */
	final String RETURN_LOGIN_UNKNOW_INFO = "";

	/**
	 * code login inconnu en base
	 */
	final Integer RETURN_LOGIN_UNKNOW_CODE = Integer.valueOf(2005);

	/**
	 * Message password error
	 */
	final String RETURN_ERROR_PASSWORD_MESSAGE = "le password est faux";

	/**
	 * info password error
	 */
	final String RETURN_ERROR_PASSWORD_INFO = "veuillez renseignez le bon mot de passe";

	/**
	 * code password error
	 */
	final Integer RETURN_ERROR_PASSWORD_CODE = Integer.valueOf(2011);

	/**
	 * Message password error
	 */
	final String RETURN_ERROR_NON_ADMIN_MESSAGE = "Le user n'est pas Admin";

	/**
	 * info password error
	 */
	final String RETURN_ERROR_NON_ADMIN_INFO = "Veuillez contactez l'administrateur du site";

	/**
	 * code password error
	 */
	final Integer RETURN_ERROR_NON_ADMIN_CODE = Integer.valueOf(2070);

	/**
	 * Message password error
	 */
	final String RETURN_ERROR_BAD_REQUEST_MESSAGE = "Information manquante";

	/**
	 * info password error
	 */
	final String RETURN_ERROR_BAD_REQUEST_INFO = "bad request";

	/**
	 * code password error
	 */
	final Integer RETURN_ERROR_BAD_REQUEST_CODE = Integer.valueOf(400);

}
