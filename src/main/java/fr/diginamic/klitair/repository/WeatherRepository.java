/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Weather;

/**
 * @author Antoine
 *
 */
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
