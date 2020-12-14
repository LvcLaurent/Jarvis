package fr.lsi.jarvis.infrastructure.account.mapper;

import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.infrastructure.account.entity.AccountEntity;

/**
 * Mapper de account & accountEntity
 *
 * @author Laurent SION
 *
 */
public interface IAccountMapper {

	/**
	 * Convert account to accountEntity
	 *
	 * @param entity
	 * @return
	 * @throws JarvisException
	 */
	Account entityToAccount(AccountEntity entity) throws JarvisException;

	/**
	 * Convert accountEntity to account
	 *
	 * @param account
	 * @return
	 */
	AccountEntity accountToEntity(Account account) throws JarvisException;

}
