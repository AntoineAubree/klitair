/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Section;

/**
 * @author Antoine
 *
 */
public interface SectionRepository extends JpaRepository<Section, Long> {

	Optional<Section> findByTitle(String title);

}
