/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Message;

/**
 * @author Antoine
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long> {

}
