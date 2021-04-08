/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.TownForecastAlert;

/**
 * @author Antoine
 *
 */
public interface TownForecastAlertRepository extends JpaRepository<TownForecastAlert, Long> {

}
