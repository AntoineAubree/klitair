/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Embeddable
public class Address {

	/** nbStreet */
	@Column(name = "nb_street", length = 10, nullable = false)
	@Size(min = 1, max = 10)
	@NotNull
	private String nbStreet;

	/** street */
	@Column(length = 80, nullable = false)
	@Size(min = 1, max = 80)
	@NotNull
	private String street;

	/** user */
	private User user;

	public Address() {
	}

	/**
	 * @param nbStreet
	 * @param street
	 * @param user
	 */
	public Address(@Size(min = 1, max = 10) @NotNull String nbStreet, @Size(min = 1, max = 80) @NotNull String street,
			User user) {
		super();
		this.nbStreet = nbStreet;
		this.street = street;
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [nbStreet=");
		builder.append(nbStreet);
		builder.append(", street=");
		builder.append(street);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the nbStreet
	 */
	public String getNbStreet() {
		return nbStreet;
	}

	/**
	 * @param nbStreet the nbStreet to set
	 */
	public void setNbStreet(String nbStreet) {
		this.nbStreet = nbStreet;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	

}
