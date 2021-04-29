/**
 * 
 */
package fr.diginamic.klitair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.ForecastAlertDto;
import fr.diginamic.klitair.services.ForecastAlertService;

/**
 * @author Antoine
 *
 */
@RestController
@RequestMapping("/forecast")
public class ForecastAlertController {

	@Autowired
	ForecastAlertService forecastAlertService;

	@GetMapping()
	public ForecastAlertDto findAll() throws Exception {
		return forecastAlertService.findAll();
	}

}
