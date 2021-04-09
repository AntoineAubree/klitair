/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Town;

/**
 * @author Antoine
 *
 */
public interface TownRepository extends JpaRepository<Town, Long> {

	List<Town> findByPostCode(String postCode);

}
