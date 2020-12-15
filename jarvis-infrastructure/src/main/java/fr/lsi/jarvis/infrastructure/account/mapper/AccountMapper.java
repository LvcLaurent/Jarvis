package fr.lsi.jarvis.infrastructure.account.mapper;

import org.springframework.stereotype.Component;

import fr.lsi.jarvis.domain.account.constant.AccountConstant;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisTechnicalException;
import fr.lsi.jarvis.infrastructure.account.entity.AccountEntity;

@Component
public class AccountMapper implements IAccountMapper {

	@Override
	public Account entityToAccount(final AccountEntity entity) throws JarvisException {

		if (entity == null) {
			throw new JarvisTechnicalException(AccountConstant.RETURN_MAPPER_MESSAGE,
					AccountConstant.RETURN_MAPPER_INFO, AccountConstant.RETURN_MAPPER_CODE);
		}

		final Account result = new Account();

		result.setCity(entity.getCity());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setMail(entity.getMail());
		result.setPasswordCrypt(entity.getPasswordCrypt());
		result.setPhoneNumber(entity.getPhoneNumber());
		result.setPostalCode(entity.getPostalCode());
		result.setStreet(entity.getStreet());
		result.setUuid(entity.getUuid());
		result.setIsAdmin(entity.getIsAdmin());
		result.setIsLocalizer(entity.getIsLocalizer());
		result.setIsSms(entity.getIsSms());
		result.setIsVoice(entity.getIsVoice());
		result.setLogin(entity.getLogin());
		result.setActif(entity.getActif());
		result.setDateCreate(entity.getDateCreate());
		result.setDateLastCo(entity.getDateLastCo());

		return result;
	}

	@Override
	public AccountEntity accountToEntity(final Account account) throws JarvisException {

		if (account == null) {
			throw new JarvisTechnicalException(AccountConstant.RETURN_MAPPER_MESSAGE,
					AccountConstant.RETURN_MAPPER_INFO, AccountConstant.RETURN_MAPPER_CODE);
		}

		final AccountEntity result = new AccountEntity();

		result.setCity(account.getCity());
		result.setFirstName(account.getFirstName());
		result.setLastName(account.getLastName());
		result.setMail(account.getMail());
		result.setPasswordCrypt(account.getPasswordCrypt());
		result.setPhoneNumber(account.getPhoneNumber());
		result.setPostalCode(account.getPostalCode());
		result.setStreet(account.getStreet());
		result.setUuid(account.getUuid());
		result.setIsAdmin(account.getIsAdmin());
		result.setIsLocalizer(account.getIsLocalizer());
		result.setIsSms(account.getIsSms());
		result.setIsVoice(account.getIsVoice());
		result.setLogin(account.getLogin());
		result.setActif(account.getActif());
		result.setDateCreate(account.getDateCreate());
		result.setDateLastCo(account.getDateLastCo());

		return result;
	}

}
