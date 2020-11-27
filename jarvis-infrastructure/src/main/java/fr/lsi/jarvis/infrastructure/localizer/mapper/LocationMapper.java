package fr.lsi.jarvis.infrastructure.localizer.mapper;

import org.springframework.stereotype.Component;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;
import fr.lsi.jarvis.domain.localizer.constant.LocalizerConstant;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.infrastructure.localizer.entity.LocationEntity;

@Component
public class LocationMapper implements ILocationMapper {

	@Override
	public Location entityToLocation(final LocationEntity entity) throws JarvisException {
		if (entity == null) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE);
		}

		final Location result = new Location(entity.getLongitude(), entity.getLatitude(),
				entity.getLocationName());
		result.setListPeople(entity.getListPeople());
		result.setUuid(entity.getUuid());
		return result;
	}

	@Override
	public LocationEntity LocationToEntity(final Location location) throws JarvisException {
		if (location == null) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE);
		}

		final LocationEntity result = new LocationEntity(location.getLongitude(), location.getLatitude(),
				location.getLocationName());
		result.setListPeople(location.getListPeople());
		result.setUuid(location.getUuid());
		return result;
	}

}
