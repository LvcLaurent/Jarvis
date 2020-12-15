/**
 *
 */
package fr.lsi.jarvis.exposition.localizer;

import java.util.List;

/**
 * @author Laurent SION
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocalizerIn;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocalizerOut;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocationAddIn;
import fr.lsi.jarvis.domain.localizer.model.exposition.LocationAddUser;
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
	 * @param request request
	 * @return response
	 * @throws JarvisException
	 */
	@ApiOperation(value = "Coordinate calculation")
	@RequestMapping("/localize/calculate/{latitude}/{longitude}/{userName}")
	public LocalizerOut localizer(@PathVariable final String longitude, @PathVariable final String latitude,
			@PathVariable final String userName) throws JarvisException {
		LOGGER.info("location request for " + userName + " avec la longitude : " + longitude + " et latitude : "
				+ latitude);
		final LocalizerIn request = new LocalizerIn();
		request.setLatitude(Double.valueOf(latitude));
		request.setLongitude(Double.valueOf(longitude));
		request.setIdUser(userName);

		return this.localizerService.location(request);

	}

	/**
	 * add location request
	 *
	 * @param request request
	 * @throws JarvisException
	 */
	@ApiOperation(value = "add location")
	@PostMapping(value = "/localize/addLocation")
	public void addLocation(@RequestBody final LocationAddIn request) throws JarvisException {
		LOGGER.info("add location");
		this.localizerService.addLocation(request);

	}

	/**
	 * add user at location request
	 *
	 * @param request request
	 * @throws JarvisException
	 */
	@ApiOperation(value = "add user")
	@PostMapping(value = "/localize/addUser")
	public void addUser(@RequestBody final LocationAddUser request) throws JarvisException {
		LOGGER.info("add location");
		this.localizerService.addUserInLocation(request.getLocationName(), request.getName(), request.getIdCmd());

	}

	/**
	 * get all Location
	 *
	 * @param request request
	 * @throws JarvisException
	 */
	@ApiOperation(value = "add user")
	@GetMapping(value = "/localize/getLocation")
	public List<Location> getLocation() throws JarvisException {
		LOGGER.info("add location");
		return this.localizerService.findAllEntity();

	}

}
