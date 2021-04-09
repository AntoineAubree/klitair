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
public class Section {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** title */
	@Column(length = 80, nullable = false, unique = true)
	@Size(min = 1, max = 80)
	@NotNull
	private String title;

	/** user */
	@ManyToOne
	@JoinColumn(name = "id_user")
//	@NotNull
	private User user;

	/** discussion thread */
	@OneToMany(mappedBy = "section")
	private Set<DiscussionThread> discussionThread = new HashSet<DiscussionThread>();

	public Section() {
	}

	public Section(@Size(min = 1, max = 80) @NotNull String title) {
		super();
		this.title = title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Section [id=");
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

}
