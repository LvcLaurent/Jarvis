package fr.lsi.jarvis.infrastructure.localizer.mapper;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.model.User;
import fr.lsi.jarvis.infrastructure.localizer.entity.UserEntity;

/**
 * Mapper de user & userEntity
 *
 * @author Laurent SION
 *
 */
public interface IUserMapper {

	/**
	 * Convert user to UserEntity
	 *
	 * @param entity
	 * @return
	 * @throws JarvisException
	 */
	User entityToUser(UserEntity entity) throws JarvisException;

	/**
	 * Convert UserEntity to user
	 *
	 * @param entity
	 * @return
	 */
	UserEntity userToEntity(User user) throws JarvisException;

}
