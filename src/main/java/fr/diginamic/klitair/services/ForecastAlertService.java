/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.ForecastAlertDto;
import fr.diginamic.klitair.repository.ForecastAlertRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class ForecastAlertService {

	@Autowired
	private ForecastAlertRepository forecastAlertRepository;

	public ForecastAlertDto findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
