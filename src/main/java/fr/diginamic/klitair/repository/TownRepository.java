/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Town;

/**
 * @author Antoine
 *
 */
public interface TownRepository extends JpaRepository<Town, Long> {

	List<Town> findByPostCodes_Code(String postCode);

	Optional<Town> findByCode(String code);

	Optional<Town> findByCodeAndPostCodes_Id(String code, Long id);

	Optional<Town> findByName(String town);
}
