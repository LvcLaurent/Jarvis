/**
 * 
 */
package fr.lsi.jarvis.exposition.localizer;

/**
 * @author Laurent SION
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.generic.GenericOut;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.LocalizerIn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for localization
 * 
 * @author Laurent SION
 *
 */
@RestController
@CrossOrigin
@Api("API for Location Management")
public class LocalizerController {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalizerController.class);
	
	/**
	 * localizer Service
	 */
	@Autowired
	ILocalizerService localizerService;
	
	/**
	 * location request
	 * 
	 * @param request
	 * 		request
	 * @return
	 * 		response
	 * @throws JarvisException
	 */
	@ApiOperation(value = "Coordinate calculation")
	@PostMapping(value = "/localize/calculation")
    public Double localizer(@RequestBody LocalizerIn request) throws JarvisException {
		LOGGER.info("location request");
		
		Double distance = localizerService.location(request);
		
		return distance;
		
    }

}