package fr.diginamic.klitair.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.CoordinatesAndTimeDto;
import fr.diginamic.klitair.dto.IndicatorHistoryDto;
import fr.diginamic.klitair.entity.Section;
import fr.diginamic.klitair.services.IndicatorHistoryService;

/**
 * 
 * @author StephanieMC
 *
 */
@RestController
@RequestMapping("/history")
public class IndicatorHistoryController {
	
	@Autowired
	 IndicatorHistoryService indicatorHistoryService;
	
	@GetMapping()
	 public IndicatorHistoryDto findByDateAndTown(@RequestBody CoordinatesAndTimeDto coordinatesAndTimeDto ) {
		return indicatorHistoryService.findByDateAndTown(coordinatesAndTimeDto);
		
	}

}
