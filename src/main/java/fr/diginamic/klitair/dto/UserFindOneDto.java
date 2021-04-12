/**
 * 
 */
package fr.diginamic.klitair.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antoine
 *
 */
public class UserFindOneDto {

	/** pseudo */
	@Size(min = 2, max = 50)
	@NotNull
	private String pseudo;

	/** password */
	@Size(min = 8, max = 36)
	@NotNull
	// TODO check if password is ok
	private String password;

	public UserFindOneDto() {
	}

	public UserFindOneDto(@Size(min = 2, max = 50) @NotNull String pseudo,
			@Size(min = 8, max = 36) @NotNull String password) {
		super();
		this.pseudo = pseudo;
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserFindOneDto [pseudo=");
		builder.append(pseudo);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
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

}
