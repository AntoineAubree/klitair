package fr.diginamic.klitair.api.meteo;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.diginamic.klitair.utils.RestTemplateSingleton;

/**
 * @author anton
 *
 */
public class WeatherApiRequest {

	private static RestTemplate restTemplate = RestTemplateSingleton.getRestTemplate();

	/**
	 * @return a List of List of Weather Data
	 * @throws Exception
	 */
	public List<List<WeatherData>> getWeatherData() throws Exception {

		String baseUrl = "https://api.meteo-concept.com/api/forecast/daily/periods?token=a3be79b283cd16d3fae3e33aa914a55fda79b070a3a7fb6ad2a81d60e316ce7b&insee=35238";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		DataApiResponse dataApiMeteo = mapper.readValue(jsonString, DataApiResponse.class);

		return dataApiMeteo.getWeathers();

	}

}
