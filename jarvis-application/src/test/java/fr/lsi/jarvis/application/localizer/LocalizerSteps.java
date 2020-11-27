package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.model.LocationAddIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocalizerSteps extends TestConfig {

	@Autowired
	ILocalizerService locationService;

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalizerSteps.class);

	private LocationAddIn location;

	@Given("L utilisateur veut ajouter {string} comme lieu")
	public void l_utilisateur_veut_ajouter_locationName_comme_lieu(final String locationName) {
		this.location = new LocationAddIn();
		LOGGER.info(locationName + " est la location");
		this.location.setLocationName(locationName);
	}

	@When("L utilisateur fait une demande d ajout avec la {double} et la {double}")
	public void l_utilisateur_fait_une_demande_d_ajout_avec_la_longitude_et_la_lattitude(final double longitude,
			final double latitude) {
		LOGGER.info(longitude + " est la longitude");
		LOGGER.info(latitude + " est la latitude");
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
