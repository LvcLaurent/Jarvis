package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.domain.localizer.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Cucumber test for add User
 *
 * @author Laurent SION
 *
 */
public class LocalizerAddUserStep extends TestConfig {

	@Autowired
	ILocalizerService locationService;

	Integer idCmd;
	String locationName;
	String userName;
	Integer codeRetour;

	@Given("L utilisateur fait la demande avec l {int} de jeedom et {string}")
	public void l_utilisateur_fait_la_demande_avec_l_de_jeedom_et(final Integer idCmd, final String locationName) {
		this.idCmd = idCmd;
		this.locationName = locationName;
	}

	@Transactional
	@Rollback(false)
	@When("avec le {word} du user l api effectue la sauvegarde en base")
	public void avec_le_pauline_du_user_l_api_effectue_la_sauvegarde_en_base(final String user) {
		this.userName = user;
		try {
			this.locationService.addUserInLocation(this.locationName, this.userName, this.idCmd);
			assertTrue(true);
		} catch (final JarvisException e) {
			this.codeRetour = e.getCode();
		}
	}

	@Then("L utilisateur verifie qu il a un retour {word}")
	public void l_utilisateur_verifie_qu_il_a_un_retour(final String status) {
		try {
			for (final Location location : this.locationService.findAllEntity()) {
				if (this.locationName.equals(location.getLocationName())) {
					for (final User user : location.getListPeople()) {
						if (this.userName.equals(user.getUser()) && this.idCmd.equals(user.getIdCmd())) {
							assertTrue("OK".equals(status));
							return;
						}
					}
				}
			}
			if ("NOK".equals(status)) {
				assertTrue(
						Integer.valueOf(1005).equals(this.codeRetour) || Integer.valueOf(1006).equals(this.codeRetour));
			}
		} catch (final JarvisException e) {
			assertFalse(true);
		}

	}

}
