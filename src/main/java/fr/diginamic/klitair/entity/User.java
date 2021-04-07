/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Entity;

/**
 * @author StephanieMC
 *
 */
@Entity
public class User {

	private Long id;
	private String pseudo;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;
	private boolean banned;

	public User() {

	}
}
