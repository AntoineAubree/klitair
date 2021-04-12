package fr.diginamic.klitair.api.meteo;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestMeteoApi {

	public static RestTemplate restTemplate = new RestTemplate();

	public void getTestMeteoApi() throws Exception {

		String baseUrl = "https://api.meteo-concept.com/api/forecast/daily/periods?token=a3be79b283cd16d3fae3e33aa914a55fda79b070a3a7fb6ad2a81d60e316ce7b&insee=35238";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		DataApiMeteo dataApiMeteo = mapper.readValue(jsonString, DataApiMeteo.class);

		dataApiMeteo.getWeather().forEach(el -> System.out.println("Météo du jour : " + el));

	}

}
