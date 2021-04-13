/**
 * 
 */
package fr.diginamic.klitair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.CoordinatesDto;
import fr.diginamic.klitair.dto.IndicatorDto;
import fr.diginamic.klitair.services.IndicatorService;

/**
 * @author Antoine
 *
 */
@RestController
@RequestMapping("/indicator")
public class IndicatorController {

	@Autowired
	IndicatorService indicatorService;

	@GetMapping()
	public IndicatorDto findByCoordinates(@RequestBody CoordinatesDto coordinatesDto) {
		try {
			return indicatorService.findByCoordinates(coordinatesDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
