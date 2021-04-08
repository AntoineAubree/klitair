/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.ReceivedAlert;

/**
 * @author Antoine
 *
 */
public interface ReceivedAlertRepository extends JpaRepository<ReceivedAlert, Long> {

}
