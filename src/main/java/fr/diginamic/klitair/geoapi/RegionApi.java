package fr.diginamic.klitair.geoapi;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.diginamic.klitair.entity.Region;

/**
 * @author anton
 *
 */
public class RegionApi {

	public static RestTemplate restTemplate = new RestTemplate();

	/**
	 * Print 10 first region returned by the api response
	 * 
	 * @throws Exception
	 */
	public void getRegionApi() throws Exception {

		String baseUrl = "https://geo.api.gouv.fr/regions?limit=10";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		List<Region> bean = mapper.readValue(jsonString, new TypeReference<List<Region>>() {
		});

		bean.forEach(el -> System.out.println(el));
	}

}
