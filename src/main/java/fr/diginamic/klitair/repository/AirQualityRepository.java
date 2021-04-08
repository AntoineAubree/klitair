/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.AirQuality;

/**
 * @author Antoine
 *
 */
public interface AirQualityRepository extends JpaRepository<AirQuality, Long> {

}
