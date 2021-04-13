/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.diginamic.klitair.entity.Department;

/**
 * @author Antoine
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByCode(String code);

	
}
