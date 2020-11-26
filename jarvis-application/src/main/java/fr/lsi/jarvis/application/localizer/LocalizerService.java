/**
 * 
 */
package fr.lsi.jarvis.application.localizer;

import org.springframework.stereotype.Service;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.localizer.ILocalizerService;
import fr.lsi.jarvis.domain.localizer.LocalizerIn;
import fr.lsi.jarvis.domain.localizer.LocationEntity;

/**
 * Locations service
 * 
 * @author Laurent SION
 *
 */
@Service
public class LocalizerService implements ILocalizerService {

	
	@Override
	public Double location(LocalizerIn demande) throws JarvisException {
		Double reponse ;
		Double longitude = 50.3098886;
		Double latitude = 3.3351432;
		LocationEntity location= new LocationEntity(longitude, latitude, "maison");
		LocationEntity location2 = new LocationEntity(demande.getLongitude(), demande.getLatitude(), "user");
		
		
		return calculDistance(location, location2);
	}

	@Override
	public Double calculDistance(LocationEntity location1, LocationEntity location2) throws JarvisException {
		//=ACOS(SIN(RADIANS(B1))*SIN(RADIANS(B2))+COS(RADIANS(B1))*COS(RADIANS(B2))*COS(RADIANS(C1-C2)))*6371.
		Double radian1 = Math.toRadians(location1.getLongitude());
		Double sin1 = Math.sin(radian1);
		Double radian2 = Math.toRadians(location2.getLongitude());
		Double sin2 = Math.sin(radian2);
		Double radian3 = Math.toRadians(location1.getLongitude());
		Double cos1 = Math.cos(radian3);
		Double radian4 = Math.toRadians(location2.getLongitude());
		Double cos2 = Math.cos(radian4);
		Double radian5 = Math.toRadians(location1.getLatitude()-location2.getLatitude());
		Double cos3 = Math.cos(radian5);
		Double avantAcos = sin1*sin2+cos1*cos2*cos3;
		Double acos = Math.acos(avantAcos);
		Double distance = acos*Double.valueOf(6371);
		return distance;
	}

}
