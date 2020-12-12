package fr.lsi.jarvis.domain.jeedom.localizer;

import fr.lsi.jarvis.domain.exception.JarvisException;

/**
 * Interface for template postToJeedom
 *
 * @author Laurent SION
 */
public interface IPushJeedom {

	/**
	 * post value to jeedom
	 *
	 * @param id
	 * @param value
	 * @throws JarvisException
	 */
	void postToVirtualJeedom(final Integer id, final String value) throws JarvisException;

	/**
	 * Push to URL
	 *
	 * @throws JarvisException
	 */
	void pushToUrl() throws JarvisException;

}
