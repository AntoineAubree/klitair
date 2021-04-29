package fr.diginamic.klitair.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.geo.adress.AddressApiRequest;
import fr.diginamic.klitair.api.meteo.WeatherApiRequest;
import fr.diginamic.klitair.api.meteo.periods.WeatherDataPeriods;
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
		String cityCode = getCityCodeWithCoordinates(indicatorDto);
		Town town = townService.findByCode(cityCode);
		modelMapper.map(town, indicatorDto);
		indicatorDto.setDate(LocalDateTime.now());
		addWeatherData(indicatorDto, town);
		
		
//		addAirQualityData(indicatorDto);

		return indicatorDto;
	}

	/**
	 * @param indicatorDto
	 * @return
	 * @throws Exception
	 */
	private String getCityCodeWithCoordinates(IndicatorDto indicatorDto) throws Exception {
		return addressApiRequest.getCodeInseeFromCoordinate(Float.toString(indicatorDto.getCoordinate().getLongitude()),
				Float.toString(indicatorDto.getCoordinate().getLatitude()));
	}

	/**
	 * @param iDto
	 * @throws Exception 
	 */
	private void addWeatherData(IndicatorDto iDto, Town town) throws Exception {
			List<DailyWeatherIndicator> dailyWeatherIndicators = new ArrayList<>();
			
			
			
			List<List<WeatherDataPeriods>> weatherDataPeriodsLists = weatherApiRequest
					.getWeatherDataPeriods(town.getCode());
			
			for (int i = 0; i < NUMBER_OF_DAYS; i++) {
				List<WeatherDataPeriods> weatherDataPeriodsList = weatherDataPeriodsLists.get(i);
				for (WeatherDataPeriods weatherDataPeriods : weatherDataPeriodsList) {
//					dailyWeatherIndicator.setDate(weatherDataPeriods.getDate());
//					dailyWeatherIndicator.setTemperature(weatherDataPeriods.getTemperature());
//					dailyWeatherIndicator.setWeatherConditions(
//							weatherConditionService.findByNumber(weatherDataPeriods.getWeatherConditions()).getState());
//					dailyWeatherIndicators.add(modelMapper.map(weatherDataPeriods, DailyWeatherIndicator.class));
				}
			}
			iDto.setDailyWeatherIndicators(dailyWeatherIndicators);
	}


	/**
	 * @param iDto
	 * @param town
	 */
	private void addAirQualityData(IndicatorDto iDto, Town town) {
		try {
			iDto.setAirQualityDatas(airQualityRequest.getAirQualityDataIndicator(town.getCode()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
