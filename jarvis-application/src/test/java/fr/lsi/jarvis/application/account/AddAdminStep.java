package fr.lsi.jarvis.application.account;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Ajouter un admin en base
 *
 * @author Laurent SION
 *
 */
public class AddAdminStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	Account account;

	Integer codeRetour = Integer.valueOf(0);

	@Given("L admin fait la demande pour le {string} et attend un {int}")
	public void l_admin_fait_la_demande_pour_le_login_et_attend_un_retour(final String login, final Integer code) {
		try {
			this.account = this.accountService.getByLogin(login);
			this.accountService.verifAccount(this.account);
		} catch (final JarvisException e) {
			this.codeRetour = e.getCode();
			assertTrue(code.equals(e.getCode()));
		}
	}

	@When("l API fait la modifcation avec le {string}, le {string} et attend le {int}")
	public void l_api_fait_la_modifcation_avec_le_login_demandeur(final String loginDemandeur, final String password,
			final Integer code) {
		final Account accountAdmin = new Account();
		accountAdmin.setPassword(password.toCharArray());
		accountAdmin.setLogin(loginDemandeur);
		if (!code.equals(this.codeRetour)) {
			try {
				this.accountService.activeAdmin(this.account.getLogin(), accountAdmin);
			} catch (final JarvisException e) {
				assertTrue(code.equals(e.getCode()));
			}
		}
	}

	@Then("Vérification en base avec le {word}")
	public void verification_en_base_avec_retour(final String status) {
		if ("OK".equals(status)) {
			try {
				this.account = this.accountService.getByLogin(this.account.getLogin());
				this.accountService.verifAccount(this.account);
				assertTrue(this.account.getIsAdmin());
			} catch (final JarvisException e) {
				assertTrue("NOK".equals(status));
			}
		}
	}

}
