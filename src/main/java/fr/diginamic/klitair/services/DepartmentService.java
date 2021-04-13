/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.geo.departement.DepartmentApiRequest;
import fr.diginamic.klitair.api.geo.departement.DepartmentDataApi;
import fr.diginamic.klitair.entity.Department;
import fr.diginamic.klitair.entity.Region;
import fr.diginamic.klitair.repository.DepartmentRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentApiRequest departmentApiRequest;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private RegionService regionService;

	public void insertDepartment() {
		List<Region> regions = regionService.findAll();
		try {
			for (DepartmentDataApi departmentData : departmentApiRequest.getDepartmentData()) {
				if (departmentRepository.findByCode(departmentData.getCode()).isEmpty()) {
					for (Region region : regions) {
						if (region.getCode().equals(departmentData.getCodeRegion())) {
							Department department = new Department();
							department.setCode(departmentData.getCode());
							department.setName(departmentData.getName());
							department.setRegion(region);
							departmentRepository.save(department);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

}
