package fr.lsi.jarvis.infrastructure.jeedom.localizer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.domain.exception.JarvisFunctionalException;
import fr.lsi.jarvis.domain.exception.JarvisTechnicalException;
import fr.lsi.jarvis.domain.jeedom.localizer.IPushJeedom;
import fr.lsi.jarvis.domain.localizer.constant.LocalizerConstant;

@Service
@Profile("!test")
public class PushDistance implements IPushJeedom {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PushDistance.class);

	@Value("${jeedom.url}")
	private String url;

	@Value("${jeedom.apikey}")
	private String apiKey;

	URL obj;
	HttpURLConnection con;
	String urlAppel;

	@Override
	public void postToVirtualJeedom(final Integer id, final String value) throws JarvisException {

		final StringBuilder sb = new StringBuilder();
		sb.append(this.url);
		sb.append("?plugin=virtual&apikey=");
		sb.append(this.apiKey);
		sb.append("&type=virtual&id=");
		sb.append(id.toString());
		sb.append("&value=");
		sb.append(value);

		this.urlAppel = sb.toString();
		LOGGER.info(this.urlAppel.toString());

		// optional default is GET
		try {
			this.obj = new URL(this.urlAppel);
			this.con = (HttpURLConnection) this.obj.openConnection();
			this.con.setRequestMethod("GET");
			// add request header
			this.con.setRequestProperty("User-Agent", "Jarvis");
			this.pushToUrl();
		} catch (final IOException e) {
			LOGGER.error("erreur technique pendant l'appel de Jeedom : " + this.urlAppel);
			throw new JarvisTechnicalException(LocalizerConstant.RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_CODE);
		}

	}

	@Override
	public void pushToUrl() throws JarvisException {
		int responseCode;
		try {
			responseCode = this.con.getResponseCode();
			if (responseCode != 200) {
				LOGGER.error("erreur fonctionnel pendant l'appel de Jeedom : " + this.urlAppel);
				throw new JarvisFunctionalException(LocalizerConstant.RETURN_JEEDOM_LOCALIZER_ERROR_MESSAGE,
						LocalizerConstant.RETURN_JEEDOM_LOCALIZER_ERROR_INFO,
						LocalizerConstant.RETURN_JEEDOM_LOCALIZER_ERROR_CODE);
			}
		} catch (final IOException e) {
			LOGGER.error("erreur technique pendant l'appel de Jeedom : " + this.urlAppel);
			throw new JarvisTechnicalException(LocalizerConstant.RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_MESSAGE,
					LocalizerConstant.RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_INFO,
					LocalizerConstant.RETURN_JEEDOM_CRASH_LOCALIZER_ERROR_CODE);
		}
	}

}
