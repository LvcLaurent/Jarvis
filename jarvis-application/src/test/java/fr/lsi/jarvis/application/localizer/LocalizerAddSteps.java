package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocationAddIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocalizerAddSteps extends TestConfig {

	@Autowired
	ILocalizerService locationService;

	private LocationAddIn location;

	@Given("L utilisateur veut ajouter {string} comme lieu")
	public void l_utilisateur_veut_ajouter_locationName_comme_lieu(final String locationName) {
		this.location = new LocationAddIn();
		this.location.setLocationName(locationName);
	}

	@When("L utilisateur fait une demande d ajout avec la {double} et la {double}")
	public void l_utilisateur_fait_une_demande_d_ajout_avec_la_longitude_et_la_lattitude(final double longitude,
			final double latitude) {
		this.location.setLatitude(Double.valueOf(latitude));
		this.location.setLongitude(Double.valueOf(longitude));
	}

	@Transactional
	@Rollback(false)
	@Then("L utilisateur verifie que le statut de la demande est {word}")
	public void l_utilisateur_verifie_que_le_statut_de_la_demande_est_status(final String status) {
		Boolean result;

		if ("OK".equals(status)) {
			result = Boolean.TRUE;
		} else {
			result = Boolean.FALSE;
		}
		try {
			this.locationService.addLocation(this.location);
			assertTrue(result);
		} catch (final JarvisException e) {
			assertFalse(result);
		} catch (final Exception e1) {
			assertTrue(Boolean.FALSE);
		}
	}

}
