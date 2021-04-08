/**
 * 
 */
package fr.diginamic.klitair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.klitair.entity.User;

/**
 * @author Antoine
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
