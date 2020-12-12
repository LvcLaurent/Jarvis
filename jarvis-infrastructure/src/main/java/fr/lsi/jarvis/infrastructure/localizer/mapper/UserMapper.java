package fr.lsi.jarvis.infrastructure.localizer.mapper;

import org.springframework.stereotype.Component;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.model.User;
import fr.lsi.jarvis.infrastructure.localizer.entity.UserEntity;

@Component
public class UserMapper implements IUserMapper {

	@Override
	public User entityToUser(final UserEntity entity) throws JarvisException {
		final User result = new User();
		result.setIdCmd(entity.getIdCmd());
		result.setUser(entity.getUser());
		result.setUuid(entity.getUuid());
		return result;
	}

	@Override
	public UserEntity userToEntity(final User user) throws JarvisException {
		final UserEntity result = new UserEntity();
		result.setIdCmd(user.getIdCmd());
		result.setUser(user.getUser());
		result.setUuid(user.getUuid());
		return result;
	}

}
