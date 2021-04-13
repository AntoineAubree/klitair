/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.PostCode;

/**
 * @author Antoine
 *
 */
public interface PostCodeRepository extends JpaRepository<PostCode, Long> {

	Optional<PostCode> findByCode(String postCode);

}
