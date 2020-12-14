package fr.lsi.jarvis.application.account;

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

	@Given("L utilisateur fait la demande de suppression pour le {word}")
	public void l_utilisateur_fait_la_demande_de_suppression_pour_le_login(final String login) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("l API fait la suppression")
	public void l_api_fait_la_suppression() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("l utilisateur nes pas présent en base avec un {word}")
	public void l_utilisateur_nes_pas_présent_en_base_avec_un_retour(final String code) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
