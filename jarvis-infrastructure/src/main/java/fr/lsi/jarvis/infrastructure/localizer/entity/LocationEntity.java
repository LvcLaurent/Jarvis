/**
 *
 */
package fr.lsi.jarvis.infrastructure.localizer.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import fr.lsi.jarvis.infrastructure.generic.EntityIO;

/**
 * Entity Location
 *
 * @author Laurent SION
 *
 */
@Entity
public class LocationEntity extends EntityIO {

	/**
	 *
	 */
	private static final long serialVersionUID = 4848920677926820418L;

	/**
	 * Final uuid
	 */
	@Id
	private String uuid;

	/**
	 * location name
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

	public LocationEntity(final Double longitude, final Double latitude, final String locationName) {
		this();
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		final UUID id = UUID.randomUUID();
		this.setUuid(id.toString());
	}

	/**
	 * Constructor
	 */
	public LocationEntity() {
		super();
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return this.longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(final Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return this.latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(final Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the listPeople
	 */
	public String getListPeople() {
		return this.listPeople;
	}

	/**
	 * @param listPeople the listPeople to set
	 */
	public void setListPeople(final String listPeople) {
		this.listPeople = listPeople;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return this.locationName;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(final String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the uuid
	 */
	@Override
	public String getUuid() {
		return this.uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	@Override
	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

}
