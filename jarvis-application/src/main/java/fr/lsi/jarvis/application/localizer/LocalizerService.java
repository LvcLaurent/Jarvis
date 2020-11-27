/**
 *
 */
package fr.lsi.jarvis.application.localizer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.ILocationRepository;
import fr.lsi.jarvis.domain.localizer.constant.LocalizerConstant;
import fr.lsi.jarvis.domain.localizer.model.LocalizerIn;
import fr.lsi.jarvis.domain.localizer.model.LocalizerOut;
import fr.lsi.jarvis.domain.localizer.model.Location;
import fr.lsi.jarvis.domain.localizer.model.LocationAddIn;
import fr.lsi.jarvis.domain.localizer.model.LocationDistance;

/**
 * Locations service
 *
 * @author Laurent SION
 *
 */
@Service
public class LocalizerService implements ILocalizerService {

	@Autowired
	ILocationRepository locationRepo;

	@Override
	public LocalizerOut location(final LocalizerIn demande) throws JarvisException {

		final List<Location> tab = this.locationRepo.findAllEntity();
		final Location locationActuel = new Location(demande.getLongitude(), demande.getLatitude(), "user");

		final LocalizerOut reponse = new LocalizerOut();

		for (final Location location : tab) {
			final LocationDistance distance = new LocationDistance();
			distance.setLocationName(location.getLocationName());
			distance.setDistance(this.calculDistance(location, locationActuel));
			reponse.getListLocationDistance().add(distance);
		}

		return reponse;
	}

	@Override
	public Integer calculDistance(final Location location1, final Location location2) throws JarvisException {
		// =ACOS(SIN(RADIANS(B1))*SIN(RADIANS(B2))+COS(RADIANS(B1))*COS(RADIANS(B2))*COS(RADIANS(C1-C2)))*6371.
		final Double radian1 = Math.toRadians(location1.getLongitude());
		final Double sin1 = Math.sin(radian1);
		final Double radian2 = Math.toRadians(location2.getLongitude());
		final Double sin2 = Math.sin(radian2);
		final Double radian3 = Math.toRadians(location1.getLongitude());
		final Double cos1 = Math.cos(radian3);
		final Double radian4 = Math.toRadians(location2.getLongitude());
		final Double cos2 = Math.cos(radian4);
		final Double radian5 = Math.toRadians(location1.getLatitude() - location2.getLatitude());
		final Double cos3 = Math.cos(radian5);
		final Double avantAcos = (sin1 * sin2) + (cos1 * cos2 * cos3);
		final Double acos = Math.acos(avantAcos);
		final Double distance = acos * Double.valueOf(6371);
		final Integer reponse = (int) (distance * 1000);

		return reponse;
	}

	@Override
	public void addLocation(final LocationAddIn request) throws JarvisException {
		final Location location = new Location(request.getLongitude(), request.getLatitude(),
				request.getLocationName());
		if (!this.locationRepo.isNewGPS(location.getLongitude(), location.getLatitude())) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_GPS_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_GPS_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_GPS_LOCALIZER_ERROR_CODE);
		}

		this.locationRepo.save(location);

	}

	@Override
	public List<Location> findAllEntity() throws JarvisException {
		return this.locationRepo.findAllEntity();
	}

	@Override
	public void deleteLocation(final Location location) throws JarvisException {
		this.locationRepo.delete(location);

	}

	@Override
	public void deleteAllLocation() throws JarvisException {
		for (final Location location : this.findAllEntity()) {
			this.deleteLocation(location);
		}

	}

}
