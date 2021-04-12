package fr.diginamic.klitair.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.CoordinatesDto;
import fr.diginamic.klitair.dto.IndicatorDto;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.TownRepository;

@Service
public class IndicatorService {
	
	@Autowired
	TownRepository townRepository;

	public IndicatorDto findByCoordinates(CoordinatesDto coordinatesDto) {
		IndicatorDto iDto = new IndicatorDto();
		// get postCode with coordinates in API
		// send exception if coordinates and postcode doesn't map
		String postCode = "44000";
		Town town = townRepository.findByPostCodes_Code(postCode).get(0);
		iDto.setDate(LocalDateTime.now());
		iDto.setPopulation(town.getPopulation());
		iDto.setTownName(town.getName());
		iDto.setTownPostCode(postCode);
		// get AirQualityData
		// get WeatherData
		return iDto;
	}

}
