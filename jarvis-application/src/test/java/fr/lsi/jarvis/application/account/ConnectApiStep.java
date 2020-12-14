package fr.lsi.jarvis.application.account;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Connection à l'api
 *
 * @author Laurent SION
 *
 */
public class ConnectApiStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	Account account;

	@Given("L utilisateur veut se connecter avec son {string} et son {string}")
	public void l_utilisateur_veut_se_connecter_avec_son_login_et_son_mdp(final String login, final String mdp) {
		this.account = new Account();
		this.account.setLogin(login);
		this.account.setPassword(mdp.toCharArray());
	}

	@When("L api vérifie que la demande est {word}")
	public void l_api_vérifie_que_la_demande_est_etat(final String etat) {
		try {
			this.accountService.verifPassword(this.account);
			assertTrue(Boolean.valueOf(etat));
		} catch (final JarvisException e) {
			assertFalse(Boolean.valueOf(etat));
		}
	}

	@Then("L utilisateur {word} à se connecter sinon il a le {int} suivant")
	public void l_utilisateur_etat_à_se_connecter_sinon_il_a_le_suivant(final String etat, final Integer code) {
		Boolean result;
		try {
			result = this.accountService.connexionToApi(this.account);
			assertTrue(result);
		} catch (final JarvisException e) {
			assertTrue(Integer.valueOf(code).equals(e.getCode()));
		}
	}

}
