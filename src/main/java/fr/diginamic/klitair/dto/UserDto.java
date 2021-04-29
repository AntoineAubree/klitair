/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.diginamic.klitair.entity.Role;

/**
 * @author Antoine
 *
 */
public class UserDto {

	/** token */
	private String token;

	/** id */
	private Long id;

	/** pseudo */
	@Size(min = 2, max = 50)
	@NotNull
	private String pseudo;

	/** password */
	@Size(min = 8, max = 36)
	@NotNull
	private String password;

	/** firstName */
	@Size(min = 2, max = 50)
	@NotNull
	private String firstName;

	/** lastName */
	@Size(min = 2, max = 50)
	@NotNull
	private String lastName;

	/** email */
	@Size(min = 1, max = 50)
	@Email
	@NotNull
	private String email;

	/** role */
	@Enumerated(EnumType.STRING)
	private Role role = Role.USER;

	/** banned */
	private boolean banned;

	/** townDto */
	@Size(min = 1, max = 200)
	@NotNull
	private String townName;

	/** postCode */
	private String postCodeCode;

	/** nbStreet */
	@Size(min = 1, max = 10)
	@NotNull
	private String addressNbStreet;

	/** street */
	@Size(min = 1, max = 80)
	@NotNull
	private String addressStreet;

	/** received alerts */
	// TODO
	private List<ReceivedAlertDto> receivedAlerts = new ArrayList<>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDto [token=");
		builder.append(token);
		builder.append(", id=");
		builder.append(id);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", password=");
		builder.append(password);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", role=");
		builder.append(role);
		builder.append(", banned=");
		builder.append(banned);
		builder.append(", townName=");
		builder.append(townName);
		builder.append(", postCodeCode=");
		builder.append(postCodeCode);
		builder.append(", addressNbStreet=");
		builder.append(addressNbStreet);
		builder.append(", addressStreet=");
		builder.append(addressStreet);
		builder.append(", receivedAlerts=");
		builder.append(receivedAlerts);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the banned
	 */
	public boolean isBanned() {
		return banned;
	}

	/**
	 * @param banned the banned to set
	 */
	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	/**
	 * @return the townName
	 */
	public String getTownName() {
		return townName;
	}

	/**
	 * @param townName the townName to set
	 */
	public void setTownName(String townName) {
		this.townName = townName;
	}

	/**
	 * @return the postCodeCode
	 */
	public String getPostCodeCode() {
		return postCodeCode;
	}

	/**
	 * @param postCodeCode the postCodeCode to set
	 */
	public void setPostCodeCode(String postCodeCode) {
		this.postCodeCode = postCodeCode;
	}

	/**
	 * @return the addressNbStreet
	 */
	public String getAddressNbStreet() {
		return addressNbStreet;
	}

	/**
	 * @param addressNbStreet the addressNbStreet to set
	 */
	public void setAddressNbStreet(String addressNbStreet) {
		this.addressNbStreet = addressNbStreet;
	}

	/**
	 * @return the addressStreet
	 */
	public String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * @param addressStreet the addressStreet to set
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/**
	 * @return the receivedAlerts
	 */
	public List<ReceivedAlertDto> getReceivedAlerts() {
		return receivedAlerts;
	}

	/**
	 * @param receivedAlerts the receivedAlerts to set
	 */
	public void setReceivedAlerts(List<ReceivedAlertDto> receivedAlerts) {
		this.receivedAlerts = receivedAlerts;
	}

}
