/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.diginamic.klitair.entity.DiscussionThread;

/**
 * @author Antoine
 *
 */
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {

	Optional<DiscussionThread> findByTitle(String title);
	
	@Query(value = "SELECT d FROM DiscussionThread d INNER JOIN d.section s WHERE s.id = ?1")
	List<DiscussionThread> findByIdSection(Long id);


}
