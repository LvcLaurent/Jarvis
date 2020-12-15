package fr.lsi.jarvis.domain.account;

import java.util.List;

import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;

public interface IAccountRepository {

	/**
	 * Allows you to save a account
	 *
	 * @param entity
	 * @return
	 * @throws JarvisException
	 */
	public Account save(final Account entity) throws JarvisException;

	/**
	 * Allows search by login
	 *
	 * @param login
	 * @return
	 * @throws JarvisException
	 */
	public Account findByLogin(final String login) throws JarvisException;

	/**
	 * return all Entity
	 *
	 * @return
	 * @throws JarvisException
	 */
	public List<Account> findAllEntity() throws JarvisException;

	/**
	 * Supprime Entity
	 *
	 * @param account
	 * @throws JarvisException
	 */
	public void delete(final Account account) throws JarvisException;

	/**
	 * return all Entity non activate
	 *
	 * @return
	 * @throws JarvisException
	 */
	public List<Account> findAllEntityInactif() throws JarvisException;

	/**
	 * Mail éxistant en base ?
	 *
	 * @param mail
	 * @throws JarvisException
	 */
	public Account getMail(final String mail) throws JarvisException;

	/**
	 * Tel existant en base ?
	 *
	 * @param tel
	 * @throws JarvisException
	 */
	public Account getTel(final String tel) throws JarvisException;

}