/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class DiscussionThread {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** title */
	@Column(length = 80, nullable = false)
	@Size(min = 1, max = 80)
	@NotNull
	private String title;

	/** user */
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotNull
	private User user;

	/** section */
	@ManyToOne()
	@JoinColumn(name = "id_section")
	@NotNull
	private Section section;

	/** messages */
	@OneToMany(mappedBy = "discussionThread")
	private Set<Message> messages = new HashSet<Message>();

	/**
	 * Constructor without arguments
	 */
	public DiscussionThread() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DiscussionThread [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/**
	 * @return the section
	 */
	public Section getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(Section section) {
		this.section = section;
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

}
