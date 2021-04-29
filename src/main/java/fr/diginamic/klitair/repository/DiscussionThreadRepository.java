/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.DiscussionThread;

/**
 * @author Antoine
 *
 */
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {

	Optional<DiscussionThread> findByTitle(String title);

	Page<DiscussionThread> findBySection_Id(Long id, Pageable pageable);

}
