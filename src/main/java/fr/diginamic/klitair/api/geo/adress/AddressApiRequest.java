/**
 * 
 */
package fr.diginamic.klitair.api.geo.adress;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.diginamic.klitair.utils.RestTemplateSingleton;

/**
 * @author anton
 *
 */

@Component
public class AddressApiRequest {

	private static RestTemplate restTemplate = RestTemplateSingleton.getRestTemplate();

	public String getCodeInseeFromCoordinate(String longitude, String latitude) throws Exception {

		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append("https://api-adresse.data.gouv.fr/reverse/?lon=");
		baseUrlBuilder.append(longitude);
		baseUrlBuilder.append("&lat=");
		baseUrlBuilder.append(latitude);
		baseUrlBuilder.append("&type=street");
		URI uri = new URI(baseUrlBuilder.toString());
		DataApiAddress bean = mapResponseToDataWeatherApi(uri);

		return bean.getFeatures().get(0).getProperties().getCityCode();
	}

	private DataApiAddress mapResponseToDataWeatherApi(URI uri) throws JsonProcessingException, JsonMappingException {
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		DataApiAddress bean = mapper.readValue(jsonString, DataApiAddress.class);
		return bean;

	}

}
