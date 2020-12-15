package fr.lsi.jarvis.application.account;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lsi.jarvis.application.utils.VerificationChaine;
import fr.lsi.jarvis.domain.account.IAccountRepository;
import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.constant.AccountConstant;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;

@Service
public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository accountRepo;

	@Override
	public void createAccount(final Account account) throws JarvisException {
		this.getLoginUnique(account.getLogin());
		this.getMailUnique(account.getMail());
		this.getTelUnique(account.getPhoneNumber());

		this.verifPassword(account);
		this.cryptPassword(account);
		this.verifPhoneNumber(account);

		account.setActif(Boolean.FALSE);
		if (!account.getIsAdmin()) {
			account.setIsAdmin(Boolean.FALSE);
		}
		account.setIsLocalizer(Boolean.FALSE);
		account.setIsSms(Boolean.FALSE);
		account.setIsVoice(Boolean.FALSE);
		account.setDateCreate(LocalDate.now());
		account.setDateLastCo(LocalDate.now());
		account.setUuid(UUID.randomUUID().toString());

		this.accountRepo.save(account);

	}

	@Override
	public void getMailUnique(final String mail) throws JarvisException {
		if (VerificationChaine.verifStringNotNullOoEmpty(mail)) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_BAD_REQUEST_MESSAGE,
					AccountConstant.RETURN_ERROR_BAD_REQUEST_INFO, AccountConstant.RETURN_ERROR_BAD_REQUEST_CODE);
		}
		if (this.accountRepo.getMail(mail) != null) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ACCOUNT_MAIL_ERROR_MESSAGE,
					AccountConstant.RETURN_ACCOUNT_MAIL_ERROR_INFO, AccountConstant.RETURN_ACCOUNT_MAIL_ERROR_CODE);
		}

	}

	@Override
	public void getTelUnique(final String tel) throws JarvisException {
		if ((this.accountRepo.getTel(tel) != null)) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ACCOUNT_PHONE_ERROR_MESSAGE,
					AccountConstant.RETURN_ACCOUNT_PHONE_ERROR_INFO, AccountConstant.RETURN_ACCOUNT_PHONE_ERROR_CODE);
		}

	}

	@Override
	public void getLoginUnique(final String login) throws JarvisException {
		try {
			if (this.getByLogin(login) != null) {
				throw new JarvisFunctionalException(AccountConstant.RETURN_ACCOUNT_LOGIN_ERROR_MESSAGE,
						AccountConstant.RETURN_ACCOUNT_LOGIN_ERROR_INFO,
						AccountConstant.RETURN_ACCOUNT_LOGIN_ERROR_CODE);
			}
		} catch (final JarvisException e) {
			if (!AccountConstant.RETURN_LOGIN_UNKNOW_CODE.equals(e.getCode())) {
				throw new JarvisFunctionalException(AccountConstant.RETURN_ACCOUNT_LOGIN_ERROR_MESSAGE,
						AccountConstant.RETURN_ACCOUNT_LOGIN_ERROR_INFO,
						AccountConstant.RETURN_ACCOUNT_LOGIN_ERROR_CODE);
			}
		}
	}

	@Override
	public Account getByLogin(final String login) throws JarvisException {
		if (VerificationChaine.verifStringNotNullOoEmpty(login)) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_BAD_REQUEST_MESSAGE,
					AccountConstant.RETURN_ERROR_BAD_REQUEST_INFO, AccountConstant.RETURN_ERROR_BAD_REQUEST_CODE);
		}
		final Account result = this.accountRepo.findByLogin(login);
		this.verifAccount(result);
		return result;
	}

	@Override
	public void verifPassword(final Account account) throws JarvisException {
		this.verifAccount(account);
		if ((account.getPassword() == null) || (account.getPassword().length < 8)) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_PASSWORD_CREATE_MESSAGE,
					AccountConstant.RETURN_PASSWORD_CREATE_INFO, AccountConstant.RETURN_PASSWORD_CREATE_CODE);
		}
		if (VerificationChaine.nbrMajuscule(account.getPassword()) == 0) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_PASSWORD_CREATE_MESSAGE,
					AccountConstant.RETURN_PASSWORD_CREATE_INFO, AccountConstant.RETURN_PASSWORD_CREATE_CODE);
		}
		if (VerificationChaine.nbrMinuscule(account.getPassword()) == 0) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_PASSWORD_CREATE_MESSAGE,
					AccountConstant.RETURN_PASSWORD_CREATE_INFO, AccountConstant.RETURN_PASSWORD_CREATE_CODE);
		}
		if (VerificationChaine.nbNumber(account.getPassword()) == 0) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_PASSWORD_CREATE_MESSAGE,
					AccountConstant.RETURN_PASSWORD_CREATE_INFO, AccountConstant.RETURN_PASSWORD_CREATE_CODE);
		}
		if (VerificationChaine.nbCharSpec(account.getPassword()) == 0) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_PASSWORD_CREATE_MESSAGE,
					AccountConstant.RETURN_PASSWORD_CREATE_INFO, AccountConstant.RETURN_PASSWORD_CREATE_CODE);
		}

	}

	@Override
	public void verifPhoneNumber(final Account account) throws JarvisException {
		this.verifAccount(account);
		if (Boolean.FALSE.equals(VerificationChaine.verifStringNotNullOoEmpty(account.getPhoneNumber()))) {
			if (account.getPhoneNumber().length() != 10) {
				throw new JarvisFunctionalException(AccountConstant.RETURN_PHONE_CREATE_MESSAGE,
						AccountConstant.RETURN_PHONE_CREATE_INFO, AccountConstant.RETURN_PHONE_CREATE_CODE);
			}
			for (int i = 0; i < account.getPhoneNumber().length(); i++) {
				if (i == 0) {
					if (account.getPhoneNumber().charAt(i) != '0') {
						throw new JarvisFunctionalException(AccountConstant.RETURN_PHONE_CREATE_MESSAGE,
								AccountConstant.RETURN_PHONE_CREATE_INFO, AccountConstant.RETURN_PHONE_CREATE_CODE);
					}
				}
				if (!Character.isDigit(account.getPhoneNumber().charAt(i))) {
					throw new JarvisFunctionalException(AccountConstant.RETURN_PHONE_CREATE_MESSAGE,
							AccountConstant.RETURN_PHONE_CREATE_INFO, AccountConstant.RETURN_PHONE_CREATE_CODE);
				}
			}
		}

	}

	@Override
	public void cryptPassword(final Account account) throws JarvisException {
		final byte[] result = new byte[account.getPassword().length];
		for (int i = 0; i < account.getPassword().length; i++) {
			result[i] = (byte) account.getPassword()[i];
		}
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
		}
		account.setPasswordCrypt(sb.toString());
	}

	@Override
	public List<Account> findAllAccount() throws JarvisException {
		return this.accountRepo.findAllEntity();
	}

	@Override
	public void deleteAllAccount() throws JarvisException {
		for (final Account account : this.findAllAccount()) {
			this.accountRepo.delete(account);
		}

	}

	@Override
	public void activeAccount(final String login, final Account account) throws JarvisException {
		if (VerificationChaine.verifStringNotNullOoEmpty(login)) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_BAD_REQUEST_MESSAGE,
					AccountConstant.RETURN_ERROR_BAD_REQUEST_INFO, AccountConstant.RETURN_ERROR_BAD_REQUEST_CODE);
		}
		if (this.isAdmin(account.getLogin()) && this.connexionToApi(account)) {
			final Account accountActivaton = this.accountRepo.findByLogin(login);
			this.verifAccount(accountActivaton);
			accountActivaton.setActif(Boolean.TRUE);
			this.accountRepo.save(accountActivaton);
		} else {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_NON_ADMIN_MESSAGE,
					AccountConstant.RETURN_ERROR_NON_ADMIN_INFO, AccountConstant.RETURN_ERROR_NON_ADMIN_CODE);
		}
	}

	@Override
	public void activeAdmin(final String login, final Account account) throws JarvisException {
		this.verifAccount(account);
		if (this.isAdmin(account.getLogin()) && this.connexionToApi(account)) {
			final Account accountActivationAdmin = this.getByLogin(login);
			this.verifAccount(accountActivationAdmin);
			accountActivationAdmin.setIsAdmin(Boolean.TRUE);
			this.accountRepo.save(accountActivationAdmin);
		} else {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_NON_ADMIN_MESSAGE,
					AccountConstant.RETURN_ERROR_NON_ADMIN_INFO, AccountConstant.RETURN_ERROR_NON_ADMIN_CODE);
		}

	}

	@Override
	public Boolean isAdmin(final String login) throws JarvisException {
		final Account accountDemandeur = this.getByLogin(login);
		this.verifAccount(accountDemandeur);
		return accountDemandeur.getIsAdmin();

	}

	@Override
	public void activeLocalizer(final String login, final Account account) throws JarvisException {
		this.verifAccount(account);
		if (this.isAdmin(account.getLogin()) && this.connexionToApi(account)) {
			final Account accountActivationLocalizer = this.getByLogin(login);
			this.verifAccount(accountActivationLocalizer);
			accountActivationLocalizer.setIsLocalizer(Boolean.TRUE);
			this.accountRepo.save(accountActivationLocalizer);
		} else {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_NON_ADMIN_MESSAGE,
					AccountConstant.RETURN_ERROR_NON_ADMIN_INFO, AccountConstant.RETURN_ERROR_NON_ADMIN_CODE);
		}

	}

	@Override
	public void deleteAccount(final String login, final Account account) throws JarvisException {
		if (this.isAdmin(account.getLogin()) && this.connexionToApi(account)) {
			final Account accountDelete = this.getByLogin(login);
			this.verifAccount(accountDelete);
			this.accountRepo.delete(accountDelete);
		} else {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_NON_ADMIN_MESSAGE,
					AccountConstant.RETURN_ERROR_NON_ADMIN_INFO, AccountConstant.RETURN_ERROR_NON_ADMIN_CODE);
		}
	}

	@Override
	public Boolean connexionToApi(final Account account) throws JarvisException {
		if (VerificationChaine.verifStringNotNullOoEmpty(account.getLogin())) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_BAD_REQUEST_MESSAGE,
					AccountConstant.RETURN_ERROR_BAD_REQUEST_INFO, AccountConstant.RETURN_ERROR_BAD_REQUEST_CODE);
		}
		this.verifPassword(account);
		this.cryptPassword(account);

		final Account accountTest = this.getByLogin(account.getLogin());
		this.verifAccount(accountTest);
		if (account.getPasswordCrypt().equals(accountTest.getPasswordCrypt())) {
			return Boolean.TRUE;
		} else {
			throw new JarvisFunctionalException(AccountConstant.RETURN_ERROR_PASSWORD_MESSAGE,
					AccountConstant.RETURN_ERROR_PASSWORD_INFO, AccountConstant.RETURN_ERROR_PASSWORD_CODE);
		}

	}

	@Override
	public void verifAccount(final Account account) throws JarvisException {
		if ((account == null) || (account.getLogin() == null) || account.getLogin().isEmpty()) {
			throw new JarvisFunctionalException(AccountConstant.RETURN_LOGIN_UNKNOW_MESSAGE,
					AccountConstant.RETURN_LOGIN_UNKNOW_INFO, AccountConstant.RETURN_LOGIN_UNKNOW_CODE);
		}
	}

	@Override
	public List<Account> getInactifAccount() throws JarvisException {
		return this.accountRepo.findAllEntityInactif();

	}

}
