/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Message;

/**
 * @author Antoine
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByDiscussionThread_Id(Long id);

	List<Message> findByUser_Id(Long id);

}
