/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class User {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** pseudo */
	@Column(length = 50, nullable = false, unique = true)
	@Size(min = 2, max = 50)
	@NotNull
	private String pseudo;

	/** firstName */
	@Column(name = "first_name", length = 50, nullable = false)
	@Size(min = 2, max = 50)
	@NotNull
	private String firstName;

	/** lastName */
	@Column(name = "last_name", length = 50, nullable = false)
	@Size(min = 2, max = 50)
	@NotNull
	private String lastName;

	/** pseudo */
	@Column(length = 50, nullable = false, unique = true)
	@Size(min = 1, max = 50)
	@Email
	@NotNull
	private String email;

	/** password */
	@Column(length = 36, nullable = false)
	@Size(min = 8, max = 36)
	@NotNull
	// TODO check if password is ok
	private String password;

	/** role */
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;

	/** banned */
	private boolean banned;

	/** town */
	@ManyToOne
	@JoinColumn(name = "id_town")
//	@NotNull
	private Town town;

	@Embedded
	@NotNull
	private Address address;

	/** favourites */
	@OneToMany(targetEntity = Favourite.class, mappedBy = "user")
	private Set<Favourite> favourites = new HashSet<Favourite>();

	/** received alerts */
	@OneToMany(targetEntity = ReceivedAlert.class, mappedBy = "user")
	private Set<ReceivedAlert> receivedAlerts = new HashSet<ReceivedAlert>();

	/** town forecast alerts */
	@OneToMany(targetEntity=ForecastAlert.class,  mappedBy = "user")
	private Set<ForecastAlert> forecastAlerts = new HashSet<ForecastAlert>();

	/** sections */
	@OneToMany(targetEntity = Section.class, mappedBy = "user")
	private Set<Section> sections = new HashSet<Section>();

	/** discussion thread */
	@OneToMany(targetEntity = DiscussionThread.class, mappedBy = "user")
	private Set<DiscussionThread> discussionThread = new HashSet<DiscussionThread>();

	/** messages */
	@OneToMany(targetEntity = Message.class, mappedBy = "user")
	private Set<Message> messages = new HashSet<Message>();

	/**
	 * Constructor WITHOUT params
	 */
	public User() {

	}

	public User(@Size(min = 2, max = 50) @NotNull String pseudo, @Size(min = 2, max = 50) @NotNull String firstName,
			@Size(min = 2, max = 50) @NotNull String lastName, @Size(min = 1, max = 50) @Email @NotNull String email,
			@NotNull Role role, boolean banned, @NotNull Address address) {
		super();
		this.pseudo = pseudo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.banned = banned;
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", pseudo=");
		builder.append(pseudo);
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
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
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
	 * @return the favourites
	 */
	public Set<Favourite> getFavourites() {
		return favourites;
	}

	/**
	 * @param favourites the favourites to set
	 */
	public void setFavourites(Set<Favourite> favourites) {
		this.favourites = favourites;
	}

	/**
	 * @return the town
	 */
	public Town getTown() {
		return town;
	}

	/**
	 * @param town the town to set
	 */
	public void setTown(Town town) {
		this.town = town;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the receivedAlerts
	 */
	public Set<ReceivedAlert> getReceivedAlerts() {
		return receivedAlerts;
	}

	/**
	 * @param receivedAlerts the receivedAlerts to set
	 */
	public void setReceivedAlerts(Set<ReceivedAlert> receivedAlerts) {
		this.receivedAlerts = receivedAlerts;
	}

	/**
	 * @return the townForecastAlerts
	 */
	public Set<ForecastAlert> getForecastAlerts() {
		return forecastAlerts;
	}

	/**
	 * @param townForecastAlerts the townForecastAlerts to set
	 */
	public void setForecastAlerts(Set<ForecastAlert> forecastAlerts) {
		this.forecastAlerts = forecastAlerts;
	}

	/**
	 * @return the sections
	 */
	public Set<Section> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	/**
	 * @return the discussionThread
	 */
	public Set<DiscussionThread> getDiscussionThread() {
		return discussionThread;
	}

	/**
	 * @param discussionThread the discussionThread to set
	 */
	public void setDiscussionThread(Set<DiscussionThread> discussionThread) {
		this.discussionThread = discussionThread;
	}

	/**
	 * @return the messages
	 */
	public Set<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
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
