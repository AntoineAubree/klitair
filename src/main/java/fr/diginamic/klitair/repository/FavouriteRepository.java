/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.Favourite;

/**
 * @author Antoine
 *
 */
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

}
