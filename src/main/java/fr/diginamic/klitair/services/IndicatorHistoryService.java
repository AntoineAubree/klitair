/**
 * 
 */
package fr.diginamic.klitair.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.airquality.AirQualityData;
import fr.diginamic.klitair.api.geo.adress.AddressApiRequest;
import fr.diginamic.klitair.api.meteo.WeatherApiRequest;
import fr.diginamic.klitair.api.meteo.day.WeatherDataDay;
import fr.diginamic.klitair.dto.Coordinate;
import fr.diginamic.klitair.dto.DailyIndicatorHistory;
import fr.diginamic.klitair.dto.IndicatorHistoryDto;
import fr.diginamic.klitair.entity.IndicatorHistory;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.IndicatorHistoryRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class IndicatorHistoryService {

	@Autowired
	private IndicatorHistoryRepository indicatorHistoryRepository;

	@Autowired
	private TownService townService;

	@Autowired
	private WeatherConditionService weatherConditionService;

	@Autowired
	private AddressApiRequest addressApiRequest;

	@Autowired
	private AirQualityApiRequest airQualityRequest;

	@Autowired
	private WeatherApiRequest weatherApiRequest;

	@Autowired
	private ModelMapper modelMapper;

	public IndicatorHistoryDto findIndicatorHistory(IndicatorHistoryDto indicatorHistoryDto) throws Exception {
		String cityCode = getCityCodeWithCoordinates(indicatorHistoryDto.getCoordinate());
		Town town = townService.findByCode(cityCode);
		modelMapper.map(town, indicatorHistoryDto);
		indicatorHistoryDto.setDate(LocalDateTime.now());
		List<IndicatorHistory> indicatorHistorys = indicatorHistoryRepository.findByDateAfterAndDateBeforeAndTown_Code(
				indicatorHistoryDto.getStartingDate(), indicatorHistoryDto.getEndingDate(), town.getCode());
		indicatorHistoryDto.setDailyIndicatorHistory(indicatorHistorys.stream()
				.map(indicatorHistory -> modelMapper.map(indicatorHistory, DailyIndicatorHistory.class))
				.collect(Collectors.toList()));
		return indicatorHistoryDto;
	}

	public void saveHistoryInDatabase() throws Exception {
		List<Town> towns = townService.findTownsOfUsersRegistered();
		for (Town town : towns) {
			IndicatorHistory indicatorHistory = new IndicatorHistory();
			WeatherDataDay weatherDataDay = weatherApiRequest.getWeatherDataDay(town.getCode());
			modelMapper.map(weatherDataDay, indicatorHistory);
			List<AirQualityData> airQualityDatas = airQualityRequest.getAirQualityDataHistory(town.getCode());
			if (!airQualityDatas.isEmpty()) {
				modelMapper.map(airQualityDatas.get(0), indicatorHistory);
			}
			indicatorHistory.setDate(LocalDate.now());
			indicatorHistory.setTown(town);
			indicatorHistory
					.setWeatherCondition(weatherConditionService.findByNumber(weatherDataDay.getWeatherConditions()));
			indicatorHistoryRepository.save(indicatorHistory);
		}
	}

	private String getCityCodeWithCoordinates(Coordinate coordinate) throws Exception {
		return addressApiRequest.getCodeInseeFromCoordinate(Float.toString(coordinate.getLongitude()),
				Float.toString(coordinate.getLatitude()));
	}

}
