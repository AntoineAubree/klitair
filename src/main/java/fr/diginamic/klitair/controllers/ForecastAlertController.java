/**
 * 
 */
package fr.diginamic.klitair.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.diginamic.klitair.entity.ForecastAlert;
import fr.diginamic.klitair.services.ForecastAlertService;

/**
 * @author StephanieMC
 *
 */

@RestController
@RequestMapping("/forecast_alert")
public class ForecastAlertController {

	@Autowired
	ForecastAlertService forecastAlertService;

	@GetMapping
	public List<ForecastAlert> findAll() {
		return forecastAlertService.findAll();

	}

}
