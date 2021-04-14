package fr.diginamic.klitair.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.geo.town.TownApiRequest;
import fr.diginamic.klitair.api.geo.town.TownDataApi;
import fr.diginamic.klitair.entity.Department;
import fr.diginamic.klitair.entity.PostCode;
import fr.diginamic.klitair.entity.Town;
import fr.diginamic.klitair.repository.TownRepository;

/**
 * 
 * @author StephanieMC
 *
 */

@Service
public class TownService {

	@Autowired
	private TownRepository townRepository;

	@Autowired
	private RegionService regionService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private TownApiRequest townApiRequest;

	@Autowired
	private PostCodeService postCodeService;

	public List<Town> findByPostCode(String postCode) {
		return townRepository.findByPostCodes_Code(postCode);
	}

	public void update() {
		LocalDateTime ldt = LocalDateTime.now();
		regionService.insertRegion();
		departmentService.insertDepartment();
		this.insertTown();
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println(Duration.between(ldt, ldt2).toMinutes());
	}

	private void insertTown() {
		List<Department> departments = departmentService.findAll();
		try {
			for (TownDataApi townData : townApiRequest.getTownData()) {
				Town town = new Town();
				Optional<Town> townOptional = townRepository.findByCode(townData.getCode());
				if (!townOptional.isEmpty()) {
					town = townOptional.orElseThrow();
				}
				for (Department department : departments) {
					if (department.getCode().equals(townData.getCodeDepartement())) {
						town.setCode(townData.getCode());
						town.setName(townData.getName());
						town.setPopulation(townData.getPopulation());
						town.setDepartment(department);
						
						for (String postCodeString : townData.getPostCodes()) {
							PostCode postCode = postCodeService.insert(postCodeString);
							System.out.println(postCode);
							if (townRepository.findByCodeAndPostCodes_Id(town.getCode(), postCode.getId()).isEmpty()) {
								town.getPostCodes().add(postCode);
							}
						}
						townRepository.save(town);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
