package fr.lsi.jarvis.infrastructure.localizer.mapper;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;
import fr.lsi.jarvis.domain.localizer.constant.LocalizerConstant;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.domain.localizer.model.User;
import fr.lsi.jarvis.infrastructure.localizer.entity.LocationEntity;
import fr.lsi.jarvis.infrastructure.localizer.entity.UserEntity;

@Component
public class LocationMapper implements ILocationMapper {

	@Autowired
	IUserMapper mapper;

	@Override
	public Location entityToLocation(final LocationEntity entity) throws JarvisException {
		if (entity == null) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE);
		}

		final Location result = new Location(entity.getLongitude(), entity.getLatitude(), entity.getLocationName());
		if (entity.getListPeople() != null) {
			result.setListPeople(new ArrayList<>());
			for (final UserEntity user : entity.getListPeople()) {
				final User add = this.mapper.entityToUser(user);
				add.setLocation(result);
				result.getListPeople().add(add);
			}
		} else {
			result.setListPeople(null);
		}
		result.setUuid(entity.getUuid());
		return result;
	}

	@Override
	public LocationEntity locationToEntity(final Location location) throws JarvisException {
		if (location == null) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE);
		}

		final LocationEntity result = new LocationEntity(location.getLongitude(), location.getLatitude(),
				location.getLocationName());
		if (location.getListPeople() != null) {
			result.setListPeople(new ArrayList<>());
			for (final User user : location.getListPeople()) {
				final UserEntity add = this.mapper.userToEntity(user);
				add.setLocation(result);
				result.getListPeople().add(add);
			}
		} else {
			result.setListPeople(null);
		}
		result.setUuid(location.getUuid());
		return result;
	}

}
