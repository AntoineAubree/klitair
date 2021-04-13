package fr.diginamic.klitair.api.airquality;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author anton
 *
 */
@Component
public class AirQualityApiRequest {

	private static final int DAY_TO_CHECK_ALERT = 2;
	private static final int LAST_DAY_TO_DISPLAY = 3;
	public static RestTemplate restTemplate = new RestTemplate();

	/**
	 * @return a list of AirQualityData from the request for 4 Days
	 * @throws Exception
	 */
	public List<AirQualityData> getAirQualityDataIndicator(String codeInsee) throws Exception {
		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append("https://data.airpl.org/api/v1/indice/commune/?commune=");
		baseUrlBuilder.append(codeInsee);
		baseUrlBuilder.append("&export=json&date__range=");
		baseUrlBuilder.append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-M-d")));
		baseUrlBuilder.append(",");
		baseUrlBuilder.append(LocalDate.now().plusDays(LAST_DAY_TO_DISPLAY).format(DateTimeFormatter.ofPattern("yyyy-M-d")));
		URI uri = new URI(baseUrlBuilder.toString());
		DataApiAir bean = mapResponseToDataAirApi(uri);
		List<AirQualityData> airQualityDataList = getAirQualityDataList(bean);
		return airQualityDataList;
	}
	
	/**
	 * @return a list of AirQualityData from the request for 1 Day
	 * @throws Exception
	 */
	public List<AirQualityData> getAirQualityDataHistory(String codeInsee) throws Exception {
		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append("https://data.airpl.org/api/v1/indice/commune/?commune=");
		baseUrlBuilder.append(codeInsee);
		baseUrlBuilder.append("&export=json&date__range=");
		baseUrlBuilder.append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-M-d")));
		baseUrlBuilder.append(",");
		baseUrlBuilder.append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-M-d")));
		URI uri = new URI(baseUrlBuilder.toString());
		DataApiAir bean = mapResponseToDataAirApi(uri);
		List<AirQualityData> airQualityDataList = getAirQualityDataList(bean);
		return airQualityDataList;
	}
	
	/**
	 * @return a list of AirQualityData from the request for 1 Day in 2 days
	 * @throws Exception
	 */
	public List<AirQualityData> getAirQualityDataAlert(String codeInsee) throws Exception {
		StringBuilder baseUrlBuilder = new StringBuilder();
		baseUrlBuilder.append("https://data.airpl.org/api/v1/indice/commune/?commune=");
		baseUrlBuilder.append(codeInsee);
		baseUrlBuilder.append("&export=json&date__range=");
		baseUrlBuilder.append(LocalDate.now().plusDays(DAY_TO_CHECK_ALERT).format(DateTimeFormatter.ofPattern("yyyy-M-d")));
		baseUrlBuilder.append(",");
		baseUrlBuilder.append(LocalDate.now().plusDays(DAY_TO_CHECK_ALERT).format(DateTimeFormatter.ofPattern("yyyy-M-d")));
		URI uri = new URI(baseUrlBuilder.toString());
		DataApiAir bean = mapResponseToDataAirApi(uri);
		List<AirQualityData> airQualityDataList = getAirQualityDataList(bean);
		return airQualityDataList;
	}

	/**
	 * @param uri
	 * @return
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 */
	private DataApiAir mapResponseToDataAirApi(URI uri) throws JsonProcessingException, JsonMappingException {
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

		String jsonString = response.getBody();
		System.out.println(jsonString);

		/* Utilisation de Jckason pour transformer une String en objet */
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		DataApiAir bean = mapper.readValue(jsonString, DataApiAir.class);
		return bean;
	}

	/**
	 * @param bean
	 * @return
	 */
	private List<AirQualityData> getAirQualityDataList(DataApiAir bean) {
		List<AirQualityData> airQualityDataList = new ArrayList<>();

		bean.getResultApi().forEach(el -> {
			AirQualityData airData = new AirQualityData();
			airData.setDate(el.getDate());

			el.getPollutans().forEach(el2 -> {
				switch (el2.getName()) {
				case "O3": {
					airData.setO3(el2.getValue());
				}
					break;
				case "PM10": {
					airData.setPm10(el2.getValue());
				}
					break;
				case "NO2": {
					airData.setNo2(el2.getValue());
				}
					break;
				case "SO2": {
					airData.setSo2(el2.getValue());
				}
					break;
				case "PM25": {
					airData.setPm25(el2.getValue());
				}
					break;
				default:
					break;
				}

			});
			airQualityDataList.add(airData);

		});
		return airQualityDataList;
	}
}
