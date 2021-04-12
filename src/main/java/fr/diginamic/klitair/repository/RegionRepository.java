/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Region;

/**
 * @author Antoine
 *
 */
public interface RegionRepository extends JpaRepository<Region, Long> {
	
	Region findByCode(String code);

}
