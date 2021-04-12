/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.IndicatorHistory;

/**
 * @author Antoine
 *
 */
public interface IndicatorHistoryRepository extends JpaRepository<IndicatorHistory, Long> {

	List<IndicatorHistory> findByDateAfterAndDateBeforeAndTown_Code(LocalDate startingDate, LocalDate endingDate,
			String code);
	
	

}
