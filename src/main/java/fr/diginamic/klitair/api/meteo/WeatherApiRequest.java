package fr.diginamic.klitair.api.meteo;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.diginamic.klitair.api.meteo.day.DataApiDay;
import fr.diginamic.klitair.api.meteo.day.WeatherDataDay;
import fr.diginamic.klitair.api.meteo.periods.DataApiPeriods;
import fr.diginamic.klitair.api.meteo.periods.WeatherDataPeriods;
import fr.diginamic.klitair.utils.RestTemplateSingleton;

/**
 * @author anton
 *
 */
@Component
public class WeatherApiRequest {

	private static RestTemplate restTemplate = RestTemplateSingleton.getRestTemplate();

	/**
	 * @return a List of List of Weather Data for a 13 days periods and every 6h
	 * @throws Exception
	 */
	public List<List<WeatherDataPeriods>> getWeatherDataPeriods(String codeInsee) throws Exception {
		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append(
				"https://api.meteo-concept.com/api/forecast/daily/periods?token=a3be79b283cd16d3fae3e33aa914a55fda79b070a3a7fb6ad2a81d60e316ce7b&insee=");
		baseUrlBuilder.append(codeInsee);
		URI uri = new URI(baseUrlBuilder.toString());
		DataApiPeriods bean = mapResponseToDataWeatherApi(uri, DataApiPeriods.class);
		return bean.getWeathers();
	}

	public WeatherDataDay getWeatherDataDay(String codeInsee) throws Exception {
		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append(
				"https://api.meteo-concept.com/api/forecast/daily?token=a3be79b283cd16d3fae3e33aa914a55fda79b070a3a7fb6ad2a81d60e316ce7b&insee=");
		baseUrlBuilder.append(codeInsee);
		URI uri = new URI(baseUrlBuilder.toString());
		DataApiDay bean = mapResponseToDataWeatherApi(uri, DataApiDay.class);
		return bean.getWeathers().get(0);
	}

	/**
	 * @param <T>
	 * @param uri
	 * @param T
	 * @return a DataApiPeriods or a DataApiDay response
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private <T> T mapResponseToDataWeatherApi(URI uri, Class<T> T)
			throws JsonProcessingException, JsonMappingException {
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		T bean = mapper.readValue(jsonString, T);
		return bean;

	}

}
