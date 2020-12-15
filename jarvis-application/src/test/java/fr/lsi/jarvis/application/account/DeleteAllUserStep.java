package fr.lsi.jarvis.application.account;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Suppression de l'intégralité des utilisateurs en base
 *
 * @author Laurent SION
 *
 */
public class DeleteAllUserStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	List<Account> listAccount;

	@Given("L api recherche l ensemble des utilisateurs")
	public void l_api_recherche_l_ensemble_des_utilisateurs() {
		try {
			this.listAccount = this.accountService.findAllAccount();
			if (this.listAccount.size() > 0) {
				assertTrue(Boolean.TRUE);
			} else {
				assertTrue(Boolean.FALSE);
			}
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@When("l API fait la suppression de l ensemble des uutilisateur")
	public void l_api_fait_la_suppression_de_l_ensemble_des_uutilisateur() {
		try {
			this.accountService.deleteAllAccount();
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@Then("Il n y a plus rien dans la base")
	public void il_n_y_a_plus_rien_dans_la_base() {
		try {
			this.listAccount = this.accountService.findAllAccount();
			if ((this.listAccount == null) || (this.listAccount.size() == 0)) {
				assertTrue(Boolean.TRUE);
			} else {
				assertTrue(Boolean.FALSE);
			}
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

}
