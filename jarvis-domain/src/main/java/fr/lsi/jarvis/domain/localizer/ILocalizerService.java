/**
 * 
 */
package fr.lsi.jarvis.domain.localizer;

import fr.lsi.jarvis.domain.exception.JarvisException;

/**
 * Location service interface
 * 
 * @author Laurent SION
 *
 */
public interface ILocalizerService {
	
	/**
	 * Location service
	 * 
	 * @param demande
	 * @return
	 * 		The distance between the user and the location
	 * @throws JarvisException
	 */
	public Double location(final LocalizerIn demande) throws JarvisException;
	
	
	public Double calculDistance(final LocationEntity location1, final LocationEntity location2) throws JarvisException;

}
