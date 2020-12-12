package fr.lsi.jarvis.application.localizer.bouchon;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.infrastructure.jeedom.localizer.PushDistance;

@Service
@Profile("test")
public class PushJeedomBouchon extends PushDistance {

	@Value("${jeedom.url}")
	private String url;

	@Value("${jeedom.apikey}")
	private String apiKey;

	@Override
	public void postToVirtualJeedom(final Integer id, final String value) throws JarvisException {
		super.postToVirtualJeedom(id, value);
	}

	@Override
	public void pushToUrl() throws JarvisException {
		assertTrue(Boolean.TRUE);
	}

}
