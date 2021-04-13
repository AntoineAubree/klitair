package fr.diginamic.klitair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import fr.diginamic.klitair.api.geo.town.TownApiRequest;
import fr.diginamic.klitair.api.geo.town.TownDataApi;
import fr.diginamic.klitair.entity.Department;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.DepartmentRepository;
import fr.diginamic.klitair.repository.TownRepository;

/**
 * 
 * @author StephanieMC
 *
 */

@Service
public class TownService {

	@Autowired
	TownRepository townRepository;

	@Autowired
	RegionService regionService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	TownApiRequest townApiRequest;

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Town> findByPostCode(String postCode) {
		return townRepository.findByPostCodes_Code(postCode);
	}

	public void update() {

		regionService.insertRegion();
		departmentService.insertDepartment();

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
