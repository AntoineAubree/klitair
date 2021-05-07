/**
 * 
 */
package fr.diginamic.klitair.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.User;

/**
 * @author Antoine
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByPseudoAndPassword(String pseudo, String password);

	Optional<User> findByPseudo(String pseudo);

	Optional<User> findByEmail(String pseudo);

	Page<User> findByPseudoContaining(String pseudo, Pageable of);

}
