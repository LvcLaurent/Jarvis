package fr.lsi.jarvis.application.account;

import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Test l'accès à la localisation
 *
 * @author Laurent Sion
 *
 */
public class AccessToLocalizer extends TestConfig {

	@Autowired
	IAccountService accountService;

	Account account;
	Integer code;

	@Given("L api fait la demande pour son {string} et son {string}")
	public void l_api_fait_la_demande_pour_le_login(final String login, final String password) {
		this.account = new Account();
		this.account.setLogin(login);
		this.account.setPassword(password.toCharArray());
	}

	@When("l API fait la vérification")
	public void l_api_fait_la_vérification() {
		try {
			this.account = this.accountService.getByLogin(this.account.getLogin());
		} catch (final JarvisException e) {
			this.code = e.getCode();
		}
	}

	@Then("l api retour qu il a {word} à localizer")
	public void l_api_retour_qu_il_a_false_à_localizer(final String status) {
		if ("true".equals(status) || "false".equals(status)) {
			this.account.getIsLocalizer().equals(Boolean.valueOf(status));
		}
		if ((this.code != null) && (!"true".equals(status) && !"false".equals(status))) {
			Integer.valueOf(status).equals(this.code);
		}
	}

}
