/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.ForecastAlert;

/**
 * @author Antoine
 *
 */
public interface ForecastAlertRepository extends JpaRepository<ForecastAlert, Long> {

	Page<ForecastAlert> findByUserNull(Pageable pageable);

}
