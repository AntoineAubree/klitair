/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Message;

/**
 * @author Antoine
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

	Page<Message> findByDiscussionThread_Id(Long id, Pageable pageable);

	Page<Message> findByUser_Id(Long id, Pageable pageable);

}
