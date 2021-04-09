package fr.diginamic.klitair.airplapi;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import fr.diginamic.klitair.entity.AirQuality;

public class TestAirPlApi {

	public static RestTemplate restTemplate = new RestTemplate();

	public List<AirQuality> getTestAirPlApi() throws Exception {

		String baseUrl = "https://data.airpl.org/api/v1/indice/commune/?commune=44026&export=json&date__range=2021-4-8,2021-4-8";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		DataApiAir bean = mapper.readValue(jsonString, DataApiAir.class);

		List<AirQuality> airJson = new ArrayList<>();

		bean.getResultApi().forEach(el -> {
			AirQuality airtest = new AirQuality();
			airtest.setDate(el.getDate());

			el.getPolluants().forEach(el2 -> {
				switch (el2.getNom()) {
				case "O3": {
					airtest.setO3(el2.getValeur());
				}
					break;
				case "PM10": {
					airtest.setPm10(el2.getValeur());
				}
					break;
				case "NO2": {
					airtest.setNo2(el2.getValeur());
				}
					break;
				case "SO2": {
					airtest.setSo2(el2.getValeur());
				}
					break;
				case "PM25": {
					airtest.setPm25(el2.getValeur());
				}
					break;
				default:
					break;
				}

			});
			airJson.add(airtest);

		});

		return airJson;

	}
}
