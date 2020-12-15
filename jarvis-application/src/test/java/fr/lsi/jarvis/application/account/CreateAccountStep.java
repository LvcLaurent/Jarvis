package fr.lsi.jarvis.application.account;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.lsi.jarvis.domain.account.IAccountService;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Cucumber test for add account
 *
 * @author Laurent SION
 *
 */
public class CreateAccountStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	Account account;

	@Given("L utilisateur veut créer un compte avec identifiant {string}, le {string} et adresse mail {string} : est-ce {word}")
	public void l_utilisateur_veut_creer_un_compte_avec_identifiant(final String login, final String tel,
			final String mail, final String status) {
		final Boolean possible = Boolean.valueOf(status);
		this.account = new Account();
		this.account.setMail(mail);
		this.account.setPhoneNumber(tel);
		this.account.setLogin(login);

		try {
			this.accountService.getMailUnique(mail);
			this.accountService.getLoginUnique(login);
			this.accountService.getTelUnique(tel);
			this.accountService.verifPhoneNumber(this.account);
			assertTrue(possible);
		} catch (final JarvisException e) {
			assertFalse(possible);
			assertTrue(Integer.valueOf(2000).equals(e.getCode()) || Integer.valueOf(2004).equals(e.getCode())
					|| Integer.valueOf(2001).equals(e.getCode()) || Integer.valueOf(2003).equals(e.getCode())
					|| Integer.valueOf(400).equals(e.getCode()));
		}
	}

	@Rollback(false)
	@When("Si le mail et le login n existe pas en base alors une demande est fait avec le {string}, l adresse {string}, le {string}, la {string}, le {string} et le {string}, avec etat {word} si pas possible {int}")
	public void si_le_mail_et_le_login_n_existe_pas_en_base_alors_une_demande_est_fait_avec_le_password_l_adresse_le_la_le_nom_et_le_prenom_si_pas_possible(
			final String mdp, final String adress, final String codePostal, final String ville, final String nom,
			final String prenom, final String admin, final Integer code) {
		this.account.setPassword(mdp.toCharArray());
		this.account.setStreet(adress);
		this.account.setPostalCode(codePostal);
		this.account.setFirstName(prenom);
		this.account.setLastName(nom);
		this.account.setCity(ville);
		this.account.setIsAdmin(Boolean.valueOf(admin));

		try {
			this.accountService.createAccount(this.account);
			assertTrue(code.equals(Integer.valueOf(200)));
		} catch (final JarvisException e) {
			assertTrue(code.equals(e.getCode()));
		}
	}

	@Then("Le compte est bien {word} dans la base de donnée en invité")
	public void le_compte_est_bien_ok_dans_la_base_de_donnée_en_invité(final String status) {
		final Boolean etat = "OK".equals(status);
		try {
			final Account result = this.accountService.getByLogin(this.account.getLogin());
			if ((result != null) && this.account.getLogin().equals(result.getLogin())
					&& this.account.getMail().equals(result.getMail())
					&& this.account.getPhoneNumber().equals(result.getPhoneNumber())) {
				assertTrue(etat);
			} else {
				assertFalse(etat);
			}
		} catch (final JarvisException e) {
			assertTrue(e.getCode().equals(Integer.valueOf(2005)) || e.getCode().equals(Integer.valueOf(400)));
		}
	}

}
