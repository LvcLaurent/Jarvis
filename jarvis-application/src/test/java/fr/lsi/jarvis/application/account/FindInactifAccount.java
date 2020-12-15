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
 * Remonte les comptes inactifs
 *
 * @author Laurent SION
 *
 */
public class FindInactifAccount extends TestConfig {

	@Autowired
	IAccountService accountService;

	List<Account> listAccount;

	@Given("L api recherche l ensemble des utilisateurs non actif")
	public void L_api_recherche_l_ensemble_des_utilisateurs_non_actif() {
		try {
			this.listAccount = this.accountService.getInactifAccount();
			assertTrue(Boolean.TRUE);
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@When("l API fait la recherche de la liste des inactif")
	public void l_API_fait_la_recherche_de_la_liste_des_inactif() {
		for (final Account account : this.listAccount) {
			if (account.getActif()) {
				assertTrue(Boolean.FALSE);
			}
		}
		assertTrue(Boolean.TRUE);
	}

	@Then("Vérification qu il y a bien le {int} de compte inactif")
	public void Verification_qu_il_y_a_bien_le_nb_de_compte_inactif(final Integer nbCompte) {
		nbCompte.equals(this.listAccount.size());
	}

}
