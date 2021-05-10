package fr.diginamic.klitair.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.airquality.AirQualityData;
import fr.diginamic.klitair.api.geo.adress.AddressApiRequest;
import fr.diginamic.klitair.api.meteo.WeatherApiRequest;
import fr.diginamic.klitair.api.meteo.periods.WeatherDataPeriods;
import fr.diginamic.klitair.dto.Coordinate;
import fr.diginamic.klitair.dto.DailyQualityIndicator;
import fr.diginamic.klitair.dto.DailyWeatherIndicator;
import fr.diginamic.klitair.dto.IndicatorDto;
import fr.diginamic.klitair.entity.Town;

@Service
public class IndicatorService {

	private static final int NUMBER_OF_DAYS = 4;

	@Autowired
	private TownService townService;

	@Autowired
	private AddressApiRequest addressApiRequest;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AirQualityApiRequest airQualityRequest;

	@Autowired
	private WeatherApiRequest weatherApiRequest;

	@Autowired
	private WeatherConditionService weatherConditionService;

	public IndicatorDto findByCoordinates(IndicatorDto indicatorDto) throws Exception {
		String cityCode = getCityCodeWithCoordinates(indicatorDto.getCoordinate());
		Town town = townService.findByCode(cityCode);
		modelMapper.map(town, indicatorDto);
		indicatorDto.setDate(LocalDateTime.now());
		addAirQualityData(indicatorDto, town);
		addWeatherData(indicatorDto, town);
		return indicatorDto;
	}

	private String getCityCodeWithCoordinates(Coordinate coordinate) throws Exception {
		return addressApiRequest.getCodeInseeFromCoordinate(Float.toString(coordinate.getLongitude()),
				Float.toString(coordinate.getLatitude()));
	}

	/**
	 * @param indicatorDto
	 * @param town
	 * @throws Exception
	 */
	private void addAirQualityData(IndicatorDto indicatorDto, Town town) throws Exception {
		List<AirQualityData> airQualityDatas = airQualityRequest.getAirQualityDataIndicator(town.getCode());
		indicatorDto.setDailyQualityIndicator(airQualityDatas.stream()
				.map(airQualityData -> modelMapper.map(airQualityData, DailyQualityIndicator.class))
				.collect(Collectors.toList()));
	}

	/**
	 * @param indicatorDto
	 * @throws Exception
	 */
	private void addWeatherData(IndicatorDto indicatorDto, Town town) throws Exception {
		List<DailyWeatherIndicator> dailyWeatherIndicators = new ArrayList<>();
		List<List<WeatherDataPeriods>> weatherDataPeriodsLists = weatherApiRequest
				.getWeatherDataPeriods(town.getCode());
		for (int i = 0; i < NUMBER_OF_DAYS; i++) {
			List<WeatherDataPeriods> weatherDataPeriodsList = weatherDataPeriodsLists.get(i);
			for (WeatherDataPeriods weatherDataPeriod : weatherDataPeriodsList) {
				DailyWeatherIndicator dailyWeatherIndicator = modelMapper.map(weatherDataPeriod,
						DailyWeatherIndicator.class);
				dailyWeatherIndicator.setWeatherConditions(
						weatherConditionService.findByNumber(weatherDataPeriod.getWeatherConditions()).getState());
				dailyWeatherIndicator.setBaliseIcon(
						weatherConditionService.findByNumber(weatherDataPeriod.getWeatherConditions()).getBaliseIcon());
				dailyWeatherIndicators.add(dailyWeatherIndicator);
			}
		}
		indicatorDto.setDailyWeatherIndicators(dailyWeatherIndicators);
	}

}
