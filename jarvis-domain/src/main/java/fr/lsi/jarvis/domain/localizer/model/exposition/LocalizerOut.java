package fr.lsi.jarvis.domain.localizer.model.exposition;

import java.util.ArrayList;
import java.util.List;

import fr.lsi.jarvis.domain.generic.GenericOut;

public class LocalizerOut extends GenericOut {

	/**
	 * List LocationDistance
	 */
	List<LocationDistance> listLocationDistance;

	public LocalizerOut() {
		super();
		this.listLocationDistance = new ArrayList<>();
	}

	/**
	 * @return the listLocationDistance
	 */
	public final List<LocationDistance> getListLocationDistance() {
		return this.listLocationDistance;
	}

	/**
	 * @param listLocationDistance the listLocationDistance to set
	 */
	public final void setListLocationDistance(final List<LocationDistance> listLocationDistance) {
		this.listLocationDistance = listLocationDistance;
	}

}
