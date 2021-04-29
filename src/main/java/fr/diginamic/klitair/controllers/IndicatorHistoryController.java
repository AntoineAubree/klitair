package fr.diginamic.klitair.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.IndicatorHistoryDto;
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
	private IndicatorHistoryService indicatorHistoryService;

	@GetMapping()
	public IndicatorHistoryDto findByDateAndTown(@Valid @RequestBody IndicatorHistoryDto indicatorHistoryDto) throws Exception {
		return indicatorHistoryService.findIndicatorHistory(indicatorHistoryDto);
	}
	
}
