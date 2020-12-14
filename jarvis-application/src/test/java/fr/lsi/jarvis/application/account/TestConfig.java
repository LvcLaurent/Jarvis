/**
 *
 */
package fr.lsi.jarvis.application.account;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.spring.CucumberContextConfiguration;

/**
 * @author Laurent SION
 *
 */

@ComponentScan("fr.lsi.jarvis")
@SpringBootTest(classes = TestConfig.class)
@ContextConfiguration
@EnableAutoConfiguration
@ActiveProfiles("test")
@EntityScan("fr.lsi.jarvis.infrastructure.account.entity")
@CucumberContextConfiguration
public class TestConfig {

}
