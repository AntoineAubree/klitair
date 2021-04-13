/**
 * 
 */
package fr.diginamic.klitair.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.airquality.AirQualityApiRequest;
import fr.diginamic.klitair.api.airquality.AirQualityData;
import fr.diginamic.klitair.dto.CoordinatesAndTimeDto;
import fr.diginamic.klitair.dto.DailyIndicatorHistory;
import fr.diginamic.klitair.dto.IndicatorHistoryDto;
import fr.diginamic.klitair.entity.IndicatorHistory;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.IndicatorHistoryRepository;
import fr.diginamic.klitair.repository.TownRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class IndicatorHistoryService {

	@Autowired
	TownRepository townRepository;

	@Autowired
	IndicatorHistoryRepository indicatorHistoryRepository;
	
	@Autowired
	AirQualityApiRequest airQualityRequest;

	public IndicatorHistoryDto findByDateAndTown(CoordinatesAndTimeDto coordinatesAndTimeDto) {
		IndicatorHistoryDto histDto = new IndicatorHistoryDto();

		// TODO
		// Get postCode with coordinates
		String postCode = "44700";
		Town town = townRepository.findByPostCodes_Code(postCode).get(0);

		histDto.setResearchDate(LocalDateTime.now());
		histDto.setPopulation(town.getPopulation());
		histDto.setTownName(town.getName());
		histDto.setTownPostCode(postCode);

		List<IndicatorHistory> indicatorHistorys = indicatorHistoryRepository.findByDateAfterAndDateBeforeAndTown_Code(
				coordinatesAndTimeDto.getStartingDate(), coordinatesAndTimeDto.getEndingDate(), town.getCode());
		List<DailyIndicatorHistory> dailyIndicatorHistorys = new ArrayList<>();
		for (IndicatorHistory indicatorHistory : indicatorHistorys) {
			DailyIndicatorHistory dIH = new DailyIndicatorHistory();
			dIH.setDate(indicatorHistory.getDate());
			dIH.setNo2(indicatorHistory.getNo2());
			dIH.setO3(indicatorHistory.getO3());
			dIH.setPm10(indicatorHistory.getPm10());
			dIH.setPm25(indicatorHistory.getPm25());
			dIH.setSo2(indicatorHistory.getSo2());
			dIH.setTemperatureMax(indicatorHistory.getTemperatureMax());
			dIH.setTemperatureMin(indicatorHistory.getTemperatureMin());
			dailyIndicatorHistorys.add(dIH);
		}
		histDto.setDailyIndicatorHistory(dailyIndicatorHistorys);
		return histDto;
	}
	
	private List<Town> getUserTowns() {
		return townRepository.findDistinctByUserIsNotNull();
	}
	
	public void createHistoryWithAirQuality() {
		List<Town> towns = this.getUserTowns();
		for (Town town : towns) {
			try {
				AirQualityData airQualityData = airQualityRequest.getAirQualityDataHistory(town.getCode()).get(0);
				IndicatorHistory indicatorHistory = new IndicatorHistory();
				indicatorHistory.setDate(LocalDate.now());
				indicatorHistory.setNo2(airQualityData.getNo2());;
				indicatorHistory.setO3(airQualityData.getO3());;
				indicatorHistory.setSo2(airQualityData.getSo2());;
				indicatorHistory.setPm10(airQualityData.getPm10());;
				indicatorHistory.setPm25(airQualityData.getPm25());;
				indicatorHistoryRepository.save(indicatorHistory);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
