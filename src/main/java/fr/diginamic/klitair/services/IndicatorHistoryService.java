/**
 * 
 */
package fr.diginamic.klitair.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.geo.adress.AddressApiRequest;
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
	private TownRepository townRepository;

	@Autowired
	private IndicatorHistoryRepository indicatorHistoryRepository;

	@Autowired
	private AddressApiRequest addressApiRequest;

	public IndicatorHistoryDto findByDateAndTown(CoordinatesAndTimeDto coordinatesAndTimeDto) throws Exception {

		IndicatorHistoryDto histDto = new IndicatorHistoryDto();
		String cityCode = addressApiRequest
				.getCodeInseeFromCoordinate(Float.toString(coordinatesAndTimeDto.getLongitude()),
						Float.toString(coordinatesAndTimeDto.getLatitude()))
				.getCityCode();

		// Get postCode with coordinates
		// String postCode = "44700";
		Town town = townRepository.findByCode(cityCode).orElseThrow();

		histDto.setResearchDate(LocalDateTime.now());
		histDto.setPopulation(town.getPopulation());
		histDto.setTownName(town.getName());
		histDto.setTownPostCode(cityCode);
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

}
