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
 * Activer le compte d'un utilisateur
 *
 * @author Laurent SION
 *
 */
public class ActiveAccountStep extends TestConfig {

	@Autowired
	IAccountService accountService;

	List<Account> listAccount;

	Account account;
	Account accountAdmin;

	Integer code;

	@Given("L admin remonte le nombre de compte à activer avec son {string} et son {string}")
	public void l_admin_remonte_le_nombre_de_compte_à_activer(final String loginAdmin, final String passwordAdmin) {
		this.accountAdmin = new Account();
		this.accountAdmin.setLogin(loginAdmin);
		this.accountAdmin.setPassword(passwordAdmin.toCharArray());
		try {
			this.listAccount = this.accountService.findAllAccount();
			if (this.listAccount.size() > 0) {
				assertTrue(Boolean.TRUE);
			} else {
				assertTrue(Boolean.FALSE);
			}
		} catch (final JarvisException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@When("L admin active le compte {string}")
	public void l_admin_active_le_compte_login(final String login) {
		try {
			this.accountService.activeAccount(login, this.accountAdmin);
			assertTrue(Boolean.TRUE);
			this.code = Integer.valueOf(200);
		} catch (final JarvisException e) {
			this.code = e.getCode();
		}
	}

	@Then("L admin vérifie que {string} est bien {int}")
	public void l_admin_vérifie_que_login_est_bien_code(final String login, final Integer code) {
		try {
			assertTrue(code.equals(this.code));
			this.account = this.accountService.getByLogin(login);
			if (code.equals(Integer.valueOf(200))) {
				assertTrue(this.account.getActif());
			}
		} catch (final JarvisException e) {
			assertTrue(code.equals(e.getCode()));
		}
	}

}
