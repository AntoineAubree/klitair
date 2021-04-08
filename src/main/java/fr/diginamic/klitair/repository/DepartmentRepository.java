/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Department;

/**
 * @author Antoine
 *
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
