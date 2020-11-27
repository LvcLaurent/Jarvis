/**
 *
 */
package fr.lsi.jarvis.domain.localizer.model;

import java.util.UUID;

import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;
import fr.lsi.jarvis.domain.localizer.constant.LocalizerConstant;

/**
 * Entity Location
 *
 * @author Laurent SION
 *
 */
public class Location {

	/**
	 * unique uuid of the location
	 */
	private String uuid;

	/**
	 * name location
	 */
	private String locationName;

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
	private String listPeople;

	/**
	 * Constructor of locationEntity
	 *
	 * @param longitude
	 * @param latitude
	 * @param location
	 * @throws JarvisFunctionalException
	 */
	public Location(final Double longitude, final Double latitude, final String location)
			throws JarvisFunctionalException {
		if ((longitude == null) || (latitude == null) || (location == null) || location.isEmpty()) {
			throw new JarvisFunctionalException(LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_CONSTRUTOR_LOCALIZER_ERROR_CODE);
		}
		this.longitude = longitude;
		this.latitude = latitude;
		this.locationName = location;
		this.uuid = UUID.randomUUID().toString();
	}

	/**
	 * @return the longitude
	 */
	public final Double getLongitude() {
		return this.longitude;
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
		return this.latitude;
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
	public final String getListPeople() {
		return this.listPeople;
	}

	/**
	 * @param listPeople the listPeople to set
	 */
	public final void setListPeople(final String listPeople) {
		this.listPeople = listPeople;
	}

	/**
	 * @return the uuid
	 */
	public final String getUuid() {
		return this.uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public final void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the locationName
	 */
	public final String getLocationName() {
		return this.locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public final void setLocationName(final String locationName) {
		this.locationName = locationName;
	}

}
