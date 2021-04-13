package fr.diginamic.klitair.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fr.diginamic.klitair.api.geo.town.TownApiRequest;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.TownRepository;
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
	TownService townService;

	@Autowired
	TownRepository townRepository;

	@Autowired
	TownApiRequest townApiRequest;

	

	@GetMapping("{postCode}")
	public List<Town> findByPostcode(@PathVariable String postCode) {
		return townService.findByPostCode(postCode);
	}

	@PutMapping
	public void update() {
		townService.update();
	}

	

}
