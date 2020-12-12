package fr.lsi.jarvis.infrastructure.generic;

import java.io.Serializable;

import javax.persistence.Id;

public abstract class EntityIO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -604635961650509197L;

	@Id
	private String uuid;

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return this.uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

}
