/**
 * 
 */
package fr.lsi.jarvis.application.localizer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.LocationEntity;


/**
 * Test on the distance calculation between two locations
 * 
 * @author Laurent SION
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
public class CalculDistanceTest {
	
	static LocationEntity locationMaison;
	
	static LocationEntity locationDenain;
	
	@Autowired
	ILocalizerService localisationService;
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalculDistanceTest.class);
	
	/**
	 * Initialisation des tests
	 * 
	 * @throws JarvisException
	 */
	@Before
	public void beforeTest() throws JarvisException {
		LOGGER.info("Init des test");
		Double longitudeMaison = 50.3098886;
		Double latitudeMaison = 3.3351432;
		Double longitudeDenain = 50.3271336;
		Double latitudeDenain = 3.3968988;
		locationMaison = new LocationEntity(longitudeMaison, latitudeMaison, "maison");
		locationDenain = new LocationEntity(longitudeDenain, latitudeDenain, "user");
	}
	
	@Test
	public void testMaison() throws JarvisException {
		
		
		Double distance = localisationService.calculDistance(locationMaison, locationMaison);
		distance = distance*1000;
		LOGGER.info("la distance est de : " + distance.toString());
		if(distance > Double.valueOf(100)) {
			LOGGER.error("la distance est supérieur à 100 : ");
			Assert.isTrue(false);
		}
	}

}
