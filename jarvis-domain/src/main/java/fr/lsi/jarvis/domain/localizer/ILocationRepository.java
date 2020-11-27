package fr.lsi.jarvis.domain.localizer;

import java.util.List;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.model.Location;

/**
 * Interface repository localisation
 *
 * @author Laurent SION
 *
 */
public interface ILocationRepository {

	/**
	 * Allows you to save a location
	 *
	 * @param entity
	 * @return
	 * @throws JarvisException
	 */
	public Location save(final Location entity) throws JarvisException;

	/**
	 * Allows search by GPS coordinate
	 *
	 * @param longitude
	 * @param latitude
	 * @return
	 */
	public boolean isNewGPS(final Double longitude, final double latitude);

	/**
	 * return all Entity
	 *
	 * @return
	 * @throws JarvisException
	 */
	public List<Location> findAllEntity() throws JarvisException;

}
