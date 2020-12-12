package fr.lsi.jarvis.application.localizer;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.lsi.jarvis.domain.localizer.ILocationRepository;

/**
 * Test du context Spring boot pour les test
 *
 * @author Laurent SION
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class ContextTest {

	@Autowired
	DataSource dataSource;
	@Autowired
	EntityManager entityManager;
	@Autowired
	ILocationRepository locationRepo;

	@Test
	public void injectedComponentsAreNotNull() {
		assertTrue(this.dataSource != null);
		assertTrue(this.entityManager != null);
		assertTrue(this.locationRepo != null);
	}

}
