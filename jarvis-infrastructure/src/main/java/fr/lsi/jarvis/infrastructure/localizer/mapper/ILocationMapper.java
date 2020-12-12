package fr.lsi.jarvis.infrastructure.localizer.mapper;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.infrastructure.localizer.entity.LocationEntity;

/**
 * Mapper de location & locationEntity
 *
 * @author Laurent SION
 *
 */
public interface ILocationMapper {

	/**
	 * Convert Location to LocationEntity
	 *
	 * @param entity
	 * @return
	 * @throws JarvisException
	 */
	Location entityToLocation(LocationEntity entity) throws JarvisException;

	/**
	 * Convert LocationEntity to Location
	 *
	 * @param entity
	 * @return
	 */
	LocationEntity locationToEntity(Location location) throws JarvisException;

}
