/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.api.geo.departement.DepartmentApiRequest;
import fr.diginamic.klitair.api.geo.departement.DepartmentDataApi;
import fr.diginamic.klitair.entity.Department;
import fr.diginamic.klitair.entity.Region;
import fr.diginamic.klitair.repository.DepartmentRepository;
import fr.diginamic.klitair.repository.RegionRepository;

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
	private RegionRepository regionRepository;
	 
	public void insertDepartment() {
		try {
			for ( DepartmentDataApi departmentData: departmentApiRequest.getDepartmentData()) {
				if (departmentRepository.findByCode(departmentData.getCode()) == null) {
					Department department = new Department();
					department.setCode(departmentData.getCode());
					department.setName(departmentData.getName());
					Region region = regionRepository.findByCode(departmentData.getCodeRegion());
					if (region != null) {
						department.setRegion(region);
						departmentRepository.save(department);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
