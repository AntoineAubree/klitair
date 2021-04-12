/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.DiscussionThread;

/**
 * @author Antoine
 *
 */
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {

	Optional<DiscussionThread> findByTitle(String title);

	List<DiscussionThread> findBySection_Id(Long id);

}
