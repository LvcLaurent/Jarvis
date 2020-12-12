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
	 * is GPS coordinate
	 *
	 * @param longitude
	 * @param latitude
	 * @return
	 * @throws JarvisException
	 */
	public boolean isNewGPS(final Double longitude, final double latitude) throws JarvisException;

	/**
	 * Allows search by GPS coordinate
	 *
	 * @param longitude
	 * @param latitude
	 * @return
	 * @throws JarvisException
	 */
	public Location findByGps(final Double longitude, final double latitude) throws JarvisException;

	/**
	 * Allows search by location name
	 *
	 * @param name
	 * @return
	 * @throws JarvisException
	 */
	public Location findByName(final String locationName) throws JarvisException;

	/**
	 * return all Entity
	 *
	 * @return
	 * @throws JarvisException
	 */
	public List<Location> findAllEntity() throws JarvisException;

	/**
	 * Supprime Entity
	 *
	 * @param location
	 * @throws JarvisException
	 */
	public void delete(final Location location) throws JarvisException;

}
