package fr.diginamic.klitair.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.services.RegionService;

/**
 * 
 * @author StephanieMC
 *
 */
@RestController
@RequestMapping("/region")
public class RegionController {

	@Autowired
	RegionService regionService;

	@GetMapping()
	public void insert() {
		regionService.insertRegion();
	}
}
