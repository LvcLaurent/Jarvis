package fr.lsi.jarvis.application.account;

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

	@Given("L api fait la demande pour le {word}")
	public void l_api_fait_la_demande_pour_le_login(final String login) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("l API fait la vérification")
	public void l_api_fait_la_vérification() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("l api retour qu il a {word} à localizer")
	public void l_api_retour_qu_il_a_false_à_localizer(final String status) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
