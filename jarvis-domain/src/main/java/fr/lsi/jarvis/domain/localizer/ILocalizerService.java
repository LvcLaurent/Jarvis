/**
 *
 */
package fr.lsi.jarvis.domain.localizer;

import java.util.List;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.model.LocalizerIn;
import fr.lsi.jarvis.domain.localizer.model.LocationAddIn;
import fr.lsi.jarvis.domain.localizer.model.Location;

/**
 * Location service interface
 *
 * @author Laurent SION
 *
 */
public interface ILocalizerService {

	/**
	 * Location service
	 *
	 * @param demande
	 * @return The distance between the user and the location
	 * @throws JarvisException
	 */
	public Double location(final LocalizerIn demande) throws JarvisException;

	/**
	 * Distance calculation between two locations
	 *
	 * @param location1
	 * @param location2
	 * @return
	 * @throws JarvisException
	 */
	public Double calculDistance(final Location location1, final Location location2) throws JarvisException;

	/**
	 * location add function
	 *
	 * @param request
	 * @throws JarvisException
	 */
	public void addLocation(final LocationAddIn request) throws JarvisException;

	/**
	 * return all Entity
	 *
	 * @return
	 * @throws JarvisException
	 */
	public List<Location> findAllEntity() throws JarvisException;

}
