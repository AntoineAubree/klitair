/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.WeatherCondition;

/**
 * @author Antoine
 *
 */
public interface WeatherConditionRepository extends JpaRepository<WeatherCondition, Long> {

}
