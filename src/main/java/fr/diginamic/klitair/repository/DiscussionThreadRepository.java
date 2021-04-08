/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.DiscussionThread;

/**
 * @author Antoine
 *
 */
public interface DiscussionThreadRepository extends JpaRepository<DiscussionThread, Long> {

}
