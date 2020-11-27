package fr.lsi.jarvis.domain.localizer.model;

public class LocationDistance {

	/**
	 * Distance du lieux
	 */
	private Integer distance;

	/**
	 * name location
	 */
	private String locationName;

	/**
	 * Constructor
	 */
	public LocationDistance() {
		super();
	}

	/**
	 * @return the distance
	 */
	public final Integer getDistance() {
		return this.distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public final void setDistance(final Integer distance) {
		this.distance = distance;
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
