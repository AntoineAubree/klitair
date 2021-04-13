package fr.diginamic.klitair.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.geo.adress.AddressApiRequest;
import fr.diginamic.klitair.api.meteo.WeatherApiRequest;
import fr.diginamic.klitair.api.meteo.periods.WeatherDataPeriods;
import fr.diginamic.klitair.dto.CoordinatesDto;
import fr.diginamic.klitair.dto.DailyWeatherIndicator;
import fr.diginamic.klitair.dto.IndicatorDto;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.TownRepository;

@Service
public class IndicatorService {

	private static final int NUMBER_OF_DAYS = 4;

	@Autowired
	private TownRepository townRepository;

	@Autowired
	private AirQualityApiRequest airQualityRequest;

	@Autowired
	private WeatherApiRequest weatherApiRequest;

	@Autowired
	private AddressApiRequest addressApiRequest;

	@Autowired
	private WeatherConditionService weatherConditionService;

	public IndicatorDto findByCoordinates(CoordinatesDto coordinatesDto) throws Exception {
		IndicatorDto iDto = new IndicatorDto();
		String cityCode = addressApiRequest.getCodeInseeFromCoordinate(Float.toString(coordinatesDto.getLongitude()),
				Float.toString(coordinatesDto.getLatitude())).getCityCode();

		// TODO
		// get postCode with coordinates in API
		// send exception if coordinates and postcode doesn't map
		// String code = "44109";

		Town town = townRepository.findByCode(cityCode).orElseThrow(() -> new BadRequestException("ville non présente en base"));
		iDto.setDate(LocalDateTime.now());
		iDto.setTownPostCode(cityCode);
		iDto.setPopulation(town.getPopulation());
		iDto.setTownName(town.getName());
		addAirQualityData(iDto, town);
		addWeatherData(iDto, town);

		return iDto;
	}

	/**
	 * @param iDto
	 */
	private void addWeatherData(IndicatorDto iDto, Town town) {
		try {
			List<DailyWeatherIndicator> dailyWeatherIndicators = new ArrayList<>();
			List<List<WeatherDataPeriods>> weatherDataPeriodsLists = weatherApiRequest
					.getWeatherDataPeriods(town.getCode());
			for (int i = 0; i < NUMBER_OF_DAYS; i++) {
				List<WeatherDataPeriods> weatherDataPeriodsList = weatherDataPeriodsLists.get(i);
				for (WeatherDataPeriods weatherDataPeriods : weatherDataPeriodsList) {
					DailyWeatherIndicator dailyWeatherIndicator = new DailyWeatherIndicator();
					dailyWeatherIndicator.setDate(weatherDataPeriods.getDate());
					dailyWeatherIndicator.setTemperature(weatherDataPeriods.getTemperature());
					dailyWeatherIndicator.setWeatherConditions(
							weatherConditionService.findByNumber(weatherDataPeriods.getWeatherConditions()).getState());
					dailyWeatherIndicators.add(dailyWeatherIndicator);
				}
			}
			iDto.setDailyWeatherIndicators(dailyWeatherIndicators);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
