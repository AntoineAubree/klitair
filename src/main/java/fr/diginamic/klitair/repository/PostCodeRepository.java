/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.PostCode;

/**
 * @author Antoine
 *
 */
public interface PostCodeRepository extends JpaRepository<PostCode, Long> {

}
