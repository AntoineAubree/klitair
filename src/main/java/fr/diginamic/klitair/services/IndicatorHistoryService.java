/**
 * 
 */
package fr.diginamic.klitair.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.klitair.dto.CoordinatesAndTimeDto;
import fr.diginamic.klitair.dto.IndicatorHistoryDto;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.IndicatorHistoryRepository;
import fr.diginamic.klitair.repository.TownRepository;

/**
 * @author StephanieMC
 *
 */
public class IndicatorHistoryService {

	@Autowired
	TownRepository townRepository;
	
	@Autowired
	IndicatorHistoryRepository indicatorHistoryRepository;

	public IndicatorHistoryDto findByDateAndTown(CoordinatesAndTimeDto coordinatesAndTimeDto) {

		IndicatorHistoryDto histDto = new IndicatorHistoryDto();
		

		String postCode = "44700";
		Town town = townRepository.findByPostCodes_Code(postCode).get(0);
		
		histDto.setResearchDate(LocalDateTime.now());
		histDto.setPopulation(town.getPopulation());
		histDto.setTownName(town.getName());
		histDto.setTownPostCode(postCode);
		
		histDto.setIndicatorHistory(indicatorHistoryRepository.findByDateAfterAndDateBeforeAndTown_Code(coordinatesAndTimeDto.getStartingDate(),coordinatesAndTimeDto.getEndingDate(),town.getCode() ));

		return histDto;
	}

}
