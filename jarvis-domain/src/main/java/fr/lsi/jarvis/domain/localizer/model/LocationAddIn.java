package fr.lsi.jarvis.domain.localizer.model;

/**
 * Request for add location
 *
 * @author Laurent SION
 *
 */
public class LocationAddIn {

	/**
	 * locationName
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
	 * Constructeur de LocalizerIn
	 */
	public LocationAddIn() {
		super();
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

}
