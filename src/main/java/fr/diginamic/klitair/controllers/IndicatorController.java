/**
 * 
 */
package fr.diginamic.klitair.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping()
	public IndicatorDto findByCoordinates(@Valid @RequestBody IndicatorDto indicatorDto) throws Exception {
		return indicatorService.findByCoordinates(indicatorDto);
	}

}
