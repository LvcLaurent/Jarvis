package fr.lsi.jarvis.application.account;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.lsi.jarvis.application.utils.VerificationChaine;
import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Ajouter l'acces à la localisation
 *
 * @author Laurent SION
 *
 */
public class AddLocalizerStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	Account account;
	Account accountAdmin;

	Integer code;

	@Given("L admin fait la demande d acces pour le {string} avec son {string} et son {string}")
	public void l_admin_fait_la_demande_d_acces_pour_le_login(final String login, final String loginAdmin,
			final String passwordAdmin) {
		this.account = new Account();
		try {
			this.accountAdmin = this.accountService.getByLogin(loginAdmin);
		} catch (final JarvisException e) {
			assertTrue(e.getCode().equals(400));
		}
		this.account.setLogin(login);
		if (!VerificationChaine.verifStringNotNullOoEmpty(passwordAdmin) && (this.accountAdmin != null)) {
			this.accountAdmin.setPassword(passwordAdmin.toCharArray());
		}
	}

	@When("l API ajoute le droit a l api localizer")
	@Rollback(false)
	public void l_api_ajoute_le_droit_a_l_api_localizer() {

		try {
			this.accountService.activeLocalizer(this.account.getLogin(), this.accountAdmin);
		} catch (final JarvisException e) {
			this.code = e.getCode();
		}
	}

	@Then("La demande est bien enregistrer en base avec un retour {int}")
	public void la_demande_est_bien_enregistrer_en_base_avec_un_retour(final Integer code) {
		if (code.equals(Integer.valueOf(200))) {
			try {
				this.account = this.accountService.getByLogin(this.account.getLogin());
				assertTrue(this.account.getIsLocalizer());
			} catch (final JarvisException e) {
				assertTrue(e.getCode().equals(400));
			}
		} else {
			assertTrue(code.equals(this.code));
		}
	}

}
