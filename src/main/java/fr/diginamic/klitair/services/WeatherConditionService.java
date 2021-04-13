/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.entity.WeatherCondition;
import fr.diginamic.klitair.repository.WeatherConditionRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class WeatherConditionService {

	@Autowired
	private WeatherConditionRepository weatherConditionRepository;
	
	public WeatherCondition findByNumber(int number) {
		return weatherConditionRepository.findByNumber(number);
	}

}
