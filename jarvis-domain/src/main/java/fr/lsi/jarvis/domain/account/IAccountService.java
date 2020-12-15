package fr.lsi.jarvis.domain.account;

import java.util.List;

import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;

/**
 * Account service interface
 *
 * @author Laurent SION
 *
 */
public interface IAccountService {

	/**
	 * Service to create an account
	 *
	 * @param account
	 * @throws JarvisException
	 */
	public void createAccount(final Account account) throws JarvisException;

	/**
	 * Mail éxistant en base ?
	 *
	 * @param mail
	 * @throws JarvisException
	 */
	public void getMailUnique(final String mail) throws JarvisException;

	/**
	 * Tel existant en base ?
	 *
	 * @param tel
	 * @throws JarvisException
	 */
	public void getTelUnique(final String tel) throws JarvisException;

	/**
	 * Login existant en base ?
	 *
	 * @param login
	 * @throws JarvisException
	 */
	public void getLoginUnique(final String login) throws JarvisException;

	/**
	 * get Login in bdd ?
	 *
	 * @param login
	 * @throws JarvisException
	 */
	public Account getByLogin(final String login) throws JarvisException;

	/**
	 * Vérification du mot de passe
	 *
	 * @param account
	 * @return
	 * @throws JarvisException
	 */
	public void verifPassword(final Account account) throws JarvisException;

	/**
	 * Vérification du Numéro de téléphone
	 *
	 * @param account
	 * @return
	 * @throws JarvisException
	 */
	public void verifPhoneNumber(final Account account) throws JarvisException;

	/**
	 * Cryptage du password
	 *
	 * @param account
	 * @throws JarvisException
	 */
	public void cryptPassword(final Account account) throws JarvisException;

	/**
	 * find all account
	 *
	 * @return
	 * @throws JarvisException
	 */
	public List<Account> findAllAccount() throws JarvisException;

	/**
	 * delete All Account
	 *
	 * @throws JarvisException
	 */
	public void deleteAllAccount() throws JarvisException;

	/**
	 * Active account
	 *
	 * @param login
	 * @param account
	 * @throws JarvisException
	 */
	public void activeAccount(final String login, final Account account) throws JarvisException;

	/**
	 * active localizer
	 *
	 * @param login
	 * @param account
	 * @throws JarvisException
	 */
	public void activeLocalizer(final String login, final Account account) throws JarvisException;

	/**
	 * active Admin
	 *
	 * @param login
	 * @param account
	 * @throws JarvisException
	 */
	public void activeAdmin(final String login, final Account account) throws JarvisException;

	/**
	 * Savoir si un login est admin
	 *
	 * @param login
	 * @return
	 * @throws JarvisException
	 */
	public Boolean isAdmin(final String login) throws JarvisException;

	/**
	 * delete one account
	 *
	 * @param login
	 * @param account
	 * @throws JarvisException
	 */
	public void deleteAccount(final String login, final Account account) throws JarvisException;

	/**
	 * Service pour connexion
	 *
	 * @param account
	 * @return
	 * @throws JarvisException
	 */
	public Boolean connexionToApi(final Account account) throws JarvisException;

	/**
	 * Vérifie la nullité de l'account
	 *
	 * @param account
	 * @throws JarvisFunctionalException
	 */
	public void verifAccount(final Account account) throws JarvisException;

	/**
	 * Remonte la liste des comptes inactif
	 *
	 * @param account
	 * @throws JarvisFunctionalException
	 */
	public List<Account> getInactifAccount() throws JarvisException;
}
