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
 * Suppression d'un utilisateur non Admin en base
 *
 * @author Laurent SION
 *
 */
public class DeleteUserStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	Account account;
	Account accountAdmin;

	Integer code = 200;

	@Given("L admin fait la demande de suppression pour le {string}")
	public void l_utilisateur_fait_la_demande_de_suppression_pour_le_login(final String login) {
		try {
			this.account = this.accountService.getByLogin(login);
		} catch (final JarvisException e) {
			this.code = e.getCode();
		}
	}

	@When("l API fait la suppression avec le {string} et son {string}")
	public void l_api_fait_la_suppression(final String loginAdmin, final String password) {
		if (Integer.valueOf(200).equals(this.code)) {
			try {
				this.accountAdmin = this.accountService.getByLogin(loginAdmin);
				this.accountAdmin.setPassword(password.toCharArray());
				this.accountService.deleteAccount(this.account.getLogin(), this.accountAdmin);
			} catch (final JarvisException e) {
				this.code = e.getCode();
			}
		}
	}

	@Then("l utilisateur nes pas présent en base avec un {word}")
	public void l_utilisateur_nes_pas_présent_en_base_avec_un_retour(final String code) {
		if (Integer.valueOf(200).equals(this.code)) {
			try {
				this.account = this.accountService.getByLogin(this.account.getLogin());
				assertTrue(Boolean.FALSE);
			} catch (final JarvisException e) {
				assertTrue(Boolean.TRUE);
			}
		} else {
			assertTrue(Integer.valueOf(code).equals(this.code));
		}
	}

}
