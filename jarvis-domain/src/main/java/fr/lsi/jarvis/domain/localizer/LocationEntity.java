/**
 * 
 */
package fr.lsi.jarvis.domain.localizer;

import java.util.ArrayList;
import java.util.List;

import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;

/**
 * Entity Location
 * 
 * @author Laurent SION
 *
 */
public class LocationEntity {
	
	/**
	 * unique uuid of the location
	 */
	private String location;
	
	/**
	 * longitude
	 */
	private Double longitude;
	
	/**
	 * latitude
	 */
	private Double latitude;
	
	/**
	 * List of people present
	 */
	private List<String> listPeople = new ArrayList<>();
	
	
	/**
	 * Constructor of locationEntity
	 * 
	 * @param longitude
	 * @param latitude
	 * @param location
	 * @throws JarvisFunctionalException
	 */
	public LocationEntity(final Double longitude, final Double latitude, final String location) throws JarvisFunctionalException {
		if(longitude == null || latitude == null || location == null || location.isEmpty()) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_STATUS, LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE, LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO, LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE);
		}
		
		this.longitude=longitude;
		this.latitude=latitude;
		this.location=location;
	}


	/**
	 * @return the location
	 */
	public final String getLocation() {
		return location;
	}


	/**
	 * @param location the location to set
	 */
	public final void setLocation(final String location) {
		this.location = location;
	}


	/**
	 * @return the longitude
	 */
	public final Double getLongitude() {
		return longitude;
	}


	/**
	 * @param longitude the longitude to set
	 */
	public final void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}


	/**
	 * @return the latitude
	 */
	public final Double getLatitude() {
		return latitude;
	}


	/**
	 * @param latitude the latitude to set
	 */
	public final void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}


	/**
	 * @return the listPeople
	 */
	public final List<String> getListPeople() {
		return listPeople;
	}


	/**
	 * @param listPeople the listPeople to set
	 */
	public final void setListPeople(final List<String> listPeople) {
		this.listPeople = listPeople;
	}

}
