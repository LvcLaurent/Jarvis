package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.model.LocalizerIn;
import fr.lsi.jarvis.domain.localizer.model.LocalizerOut;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Cucumber test for calcul Distance
 *
 * @author Laurent SION
 *
 */
public class LocalizerGpsTest extends TestConfig {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalizerGpsTest.class);

	private LocalizerIn demande;
	private LocalizerOut reponse;

	@Autowired
	ILocalizerService locationService;

	@Given("L utilisateur veut ajouter fournit la {double} et la {double}")
	public void l_utilisateur_veut_ajouter_fournit_la_longitude_et_la_lattitude(final double longitude,
			final double latitude) {
		this.demande = new LocalizerIn();
		this.demande.setLatitude(latitude);
		this.demande.setLongitude(longitude);
	}

	@When("Un calcul est effectuer par l API")
	public void un_calcul_est_effectuer_par_l_api() {
		try {
			this.reponse = this.locationService.location(this.demande);
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@Then("la {int} et la {int} correspond bien à la distance attendu")
	public void la_distance1_et_la_distance2_correspond_bien_a_la_distance_attendu(final int distance1,
			final int distance2) {
		LOGGER.info(this.reponse.getListLocationDistance().get(0).getDistance().toString());
		LOGGER.info(this.reponse.getListLocationDistance().get(1).getDistance().toString());
		assertTrue(this.reponse.getListLocationDistance().get(0).getDistance() == distance1);
		assertTrue(this.reponse.getListLocationDistance().get(1).getDistance() == distance2);
	}
}
