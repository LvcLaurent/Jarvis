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

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

}
