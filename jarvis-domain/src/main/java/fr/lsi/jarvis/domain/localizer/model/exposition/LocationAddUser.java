package fr.lsi.jarvis.domain.localizer.model.exposition;

public class LocationAddUser {

	/**
	 * locationName
	 */
	private String locationName;

	/**
	 * name
	 */
	private String name;

	/**
	 * id cmd
	 */
	private Integer idCmd;

	/**
	 * constructor
	 */
	public LocationAddUser() {
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
	 * @return the name
	 */
	public final String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the idCmd
	 */
	public final Integer getIdCmd() {
		return this.idCmd;
	}

	/**
	 * @param idCmd the idCmd to set
	 */
	public final void setIdCmd(final Integer idCmd) {
		this.idCmd = idCmd;
	}

}
