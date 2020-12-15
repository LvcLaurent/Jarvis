package fr.lsi.jarvis.domain.localizer.model;

import java.beans.Transient;

/**
 * Entity user
 *
 * @author Laurent SION
 *
 */
public class User {

	/**
	 * unique uuid of the user
	 */
	private String uuid;

	/**
	 * name user
	 */
	private String user;

	/**
	 * id_CMD
	 */
	private Integer idCmd;

	/**
	 * location
	 */
	private Location location;

	/**
	 * Constructeur
	 */
	public User() {
		super();
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
	 * @return the user
	 */
	public final String getUser() {
		return this.user;
	}

	/**
	 * @param user the user to set
	 */
	public final void setUser(final String user) {
		this.user = user;
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

	/**
	 * @return the location
	 */
	@Transient
	public final Location getLocation() {
		return this.location;
	}

	/**
	 * @param location the location to set
	 */
	public final void setLocation(final Location location) {
		this.location = location;
	}
}
