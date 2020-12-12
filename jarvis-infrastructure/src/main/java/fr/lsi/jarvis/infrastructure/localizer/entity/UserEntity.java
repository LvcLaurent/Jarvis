package fr.lsi.jarvis.infrastructure.localizer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.lsi.jarvis.infrastructure.generic.EntityIO;

/**
 * Entity user
 *
 * @author Laurent SION
 *
 */
@Entity
@Table(name = "user_entity")
public class UserEntity extends EntityIO {

	/**
	 *
	 */
	private static final long serialVersionUID = 855505263833612126L;

	/**
	 * unique uuid of the user
	 */
	@Id
	@Column(name = "uuid")
	private String uuid;

	/**
	 * name user
	 */
	@Column(name = "userName")
	private String user;

	/**
	 * id_CMD
	 */
	@Column(name = "idCmd")
	private Integer idCmd;

	/**
	 * location
	 */
	@ManyToOne
	@JoinColumn(nullable = false)
	private LocationEntity location;

	/**
	 * Constructeur
	 */
	public UserEntity() {
		super();
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

	/**
	 * @return the user
	 */
	public String getUser() {
		return this.user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(final String user) {
		this.user = user;
	}

	/**
	 * @return the idCmd
	 */
	public Integer getIdCmd() {
		return this.idCmd;
	}

	/**
	 * @param idCmd the idCmd to set
	 */
	public void setIdCmd(final Integer idCmd) {
		this.idCmd = idCmd;
	}

	/**
	 * @return the location
	 */
	public LocationEntity getLocation() {
		return this.location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(final LocationEntity location) {
		this.location = location;
	}

}
