package fr.diginamic.klitair.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.api.geo.region.RegionDataApi;
import fr.diginamic.klitair.api.geo.town.TownApiRequest;
import fr.diginamic.klitair.api.geo.town.TownDataApi;
import fr.diginamic.klitair.entity.Department;
import fr.diginamic.klitair.entity.Region;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.DepartmentRepository;
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

	@Autowired
	DepartmentRepository departmentRepository;

	@GetMapping("{postCode}")
	public List<Town> findByPostcode(@PathVariable String postCode) {
		return townService.findByPostCode(postCode);
	}

	@PutMapping
	public void update() {

		townService.update();

	}

	@PutMapping
	public void insertTown() {
		try {
			for (TownDataApi townData : townApiRequest.getTownData()) {
				if (townRepository.findByPostCodes_Code(townData.getCode()) == null) {
					Town town = new Town();
					town.setCode(townData.getCode());
					town.setName(townData.getName());
					Department department = departmentRepository.findByCode(townData.getCodeDepartement());
					// population ?
					if (department != null) {
						town.setDepartment(department);
						townRepository.save(town);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
