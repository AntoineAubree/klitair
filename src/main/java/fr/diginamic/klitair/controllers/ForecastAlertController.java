/**
 * 
 */
package fr.diginamic.klitair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("{index}/{limit}")
	public Page<ForecastAlertDto> findAllNotAlreadySend(@PathVariable int index, @PathVariable int limit) throws Exception {
		return forecastAlertService.findAllNotAlreadySend(index, limit);
	}

	@PostMapping("{id}")
	public void sendAsAlert(@PathVariable Long id) {
		forecastAlertService.sendAsAlerte(id);
	}
	
	@PostMapping
	public void sendAllAsAlerte() {
		forecastAlertService.sendAllAsAlert();
	}
	
}
