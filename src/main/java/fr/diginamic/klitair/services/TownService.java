package fr.diginamic.klitair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	TownRepository townRepository;
	
	@Autowired 
	RegionService regionService;
	
	@Autowired
	DepartmentService departmentService;

	public List<Town> findByPostCode(String postCode) {
		return townRepository.findByPostCodes_Code(postCode);
	}

	public void update() {
		
		regionService.insertRegion();
		departmentService.insertDepartment();
		
	}

}
