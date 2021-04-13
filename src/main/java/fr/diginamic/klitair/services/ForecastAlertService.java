/**
 * 
 */
package fr.diginamic.klitair.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.klitair.dto.ForecastAlertDto;
import fr.diginamic.klitair.entity.ForecastAlert;
import fr.diginamic.klitair.repository.ForecastAlertRepository;

/**
 * @author StephanieMC
 *
 */
public class ForecastAlertService {
	
	@Autowired
	ForecastAlertRepository forecastAlertRepository;
	
	@Autowired 
	ForecastAlertDto forecastAlertDto;

	public List<ForecastAlert> findAll() {
		return forecastAlertRepository.findAll();
		
		
	}

}
