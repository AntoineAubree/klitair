/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class Message {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** content */
	@Column(length = 800, nullable = false)
	@Size(min = 1, max = 800)
	@NotNull
	private String content;

	/** date */
	@Column(nullable = false)
	@NotNull
	private LocalDateTime date;

	/** user */
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotNull
	private User user;

	/** discussion thread */
	@ManyToOne
	@JoinColumn(name = "id_discussion_thread")
	@NotNull
	private DiscussionThread discussionThread;

	public Message() {
	}

	public Message(@Size(min = 1, max = 800) @NotNull String content, @NotNull LocalDateTime date) {
		super();
		this.content = content;
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", content=");
		builder.append(content);
		builder.append(", date=");
		builder.append(date);
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
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
	public DiscussionThread getDiscussionThread() {
		return discussionThread;
	}

	/**
	 * @param discussionThread the discussionThread to set
	 */
	public void setDiscussionThread(DiscussionThread discussionThread) {
		this.discussionThread = discussionThread;
	}

}
