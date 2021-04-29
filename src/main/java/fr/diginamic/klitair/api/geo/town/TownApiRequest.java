package fr.diginamic.klitair.api.geo.town;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.diginamic.klitair.utils.RestTemplateSingleton;

/**
 * @author anton
 *
 */
@Component
public class TownApiRequest {

	private static RestTemplate restTemplate = RestTemplateSingleton.getRestTemplate();

	/**
	 * Print 10 first town returned by the api response
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public List<TownDataApi> getTownData() throws Exception {

		String baseUrl = "https://geo.api.gouv.fr/communes?code=44109";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		List<TownDataApi> bean = mapper.readValue(jsonString, new TypeReference<List<TownDataApi>>() {
		});

		// bean.forEach(el -> System.out.println(el));

		return bean;
	}

}
