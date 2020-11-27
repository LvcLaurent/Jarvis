/**
 * 
 */
package fr.lsi.jarvis.domain.localizer.model;

/**
 * Input request for the location service
 * 
 * @author Laurent SION
 *
 */
public class LocalizerIn {
	
	/**
	 * UUID of the user to locate
	 */
	private String idUser;
	
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
	public LocalizerIn() {
		super();
	}

	/**
	 * @return the idUser
	 */
	public final String getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public final void setIdUser(String idUser) {
		this.idUser = idUser;
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
	public final void setLongitude(Double longitude) {
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
	public final void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	

}
