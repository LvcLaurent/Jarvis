package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteAllLocationSteps {

	@Autowired
	ILocalizerService locationService;

	@Given("L utilisateur fait la demande")
	public void l_utilisateur_fait_la_demande() {
		try {
			assertFalse(this.locationService.findAllEntity().isEmpty());
		} catch (final JarvisException e) {
			assertTrue(false);
		}
	}

	@When("l API fait la suppression")
	public void l_api_fait_la_suppression() {
		try {
			this.locationService.deleteAllLocation();
		} catch (final JarvisException e) {
			assertTrue(false);
		}

	}

	@Then("Il n y a plus rien en base")
	public void il_n_y_a_plus_rien_en_base() {
		try {
			assertTrue(this.locationService.findAllEntity().isEmpty());
		} catch (final JarvisException e) {
			assertTrue(false);
		}

	}

}
