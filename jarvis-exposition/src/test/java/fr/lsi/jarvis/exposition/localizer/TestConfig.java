/**
 *
 */
package fr.lsi.jarvis.exposition.localizer;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.lsi.jarvis.domain.localizer.ILocationRepository;


/**
 * @author Laurent SION
 *
 */
@Configuration
@ComponentScan("fr.lsi.jarvis")
@SpringBootApplication(exclude = ILocationRepository.class)
@EnableAutoConfiguration
@EntityScan("fr.lsi.jarvis")
public class TestConfig {

}
