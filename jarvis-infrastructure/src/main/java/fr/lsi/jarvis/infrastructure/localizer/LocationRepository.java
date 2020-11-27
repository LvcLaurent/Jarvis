package fr.lsi.jarvis.infrastructure.localizer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocationRepository;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.infrastructure.generic.AbstractJpaRepository;
import fr.lsi.jarvis.infrastructure.localizer.entity.LocationEntity;
import fr.lsi.jarvis.infrastructure.localizer.mapper.ILocationMapper;

/**
 * Repository Location
 *
 * @author Laurent SION
 *
 */
@Repository
public class LocationRepository extends AbstractJpaRepository<LocationEntity> implements ILocationRepository {

	@Autowired
	ILocationMapper mapper;

	@Override
	protected Class<LocationEntity> getEntityClass() {
		return LocationEntity.class;
	}

	@Override
	public Location save(final Location entity) throws JarvisException {
		final LocationEntity location = this.save(this.mapper.LocationToEntity(entity));
		return this.mapper.entityToLocation(location);
	}

	@Override
	public boolean isNewGPS(final Double longitude, final double latitude) {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<LocationEntity> cq = cb.createQuery(LocationEntity.class);

		final Root<LocationEntity> location = cq.from(LocationEntity.class);
		final Predicate longitudeEquals = cb.equal(location.get("longitude"), longitude);
		final Predicate latitudeEquals = cb.equal(location.get("latitude"), latitude);
		cq.where(longitudeEquals, latitudeEquals);

		final TypedQuery<LocationEntity> query = this.em.createQuery(cq);

		return query.getResultList().isEmpty();
	}

	@Override
	public List<Location> findAllEntity() throws JarvisException {
		final List<LocationEntity> array = this.findAll();
		final List<Location> arrayResult = new ArrayList<>();

		for (final LocationEntity location : array) {
			arrayResult.add(this.mapper.entityToLocation(location));
		}

		return arrayResult;
	}

}
