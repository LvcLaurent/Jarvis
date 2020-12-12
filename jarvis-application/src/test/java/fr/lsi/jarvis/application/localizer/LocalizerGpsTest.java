package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocalizerIn;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocalizerOut;
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

	private LocalizerIn demande;
	private LocalizerOut reponse;

	@Mock
	HttpURLConnection mockHttpConnection;

	@Autowired
	ILocalizerService locationService;

	@Given("L utilisateur veut ajouter fournit la {double} et la {double}")
	public void l_utilisateur_veut_ajouter_fournit_la_longitude_et_la_lattitude(final double longitude,
			final double latitude) {
		this.demande = new LocalizerIn();
		this.demande.setLatitude(latitude);
		this.demande.setLongitude(longitude);
	}

	@When("Un calcul est effectuer par l API avec le {word}")
	public void un_calcul_est_effectuer_par_l_api(final String user) {
		try {
			this.demande.setIdUser(user);
			this.reponse = this.locationService.location(this.demande);
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@Then("la {int} et la {int} correspond bien à la distance attendu")
	public void la_distance1_et_la_distance2_correspond_bien_a_la_distance_attendu(final int distance1,
			final int distance2) {
		assertTrue(this.reponse.getListLocationDistance().get(0).getDistance() == distance1);
		assertTrue(this.reponse.getListLocationDistance().get(1).getDistance() == distance2);
	}
}
