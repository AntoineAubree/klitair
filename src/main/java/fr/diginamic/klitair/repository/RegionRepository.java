/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Region;

/**
 * @author Antoine
 *
 */
public interface RegionRepository extends JpaRepository<Region, Long> {
	
	Optional<Region> findByCode(String code);

}
