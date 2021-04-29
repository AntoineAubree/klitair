package fr.diginamic.klitair.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.TownDto;
import fr.diginamic.klitair.services.TownService;

/**
 * 
 * @author StephanieMC
 *
 */
@RestController
@RequestMapping("/town")
public class TownController {

	@Autowired
	private TownService townService;

	@GetMapping("{postCode}")
	public List<TownDto> findByPostcode(@PathVariable String postCode) {
		return townService.findByPostCode(postCode);
	}

	@PutMapping
	public void update() {
		townService.update();
	}

}
