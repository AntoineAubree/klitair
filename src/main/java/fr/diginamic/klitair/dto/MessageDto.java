/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antoine
 *
 */
public class MessageDto {

	/** id */
	private Long id;

	/** user id */
	@NotNull
	private Long userId;

	/** user pseudp */
	private String userPseudo;

	/** discussionThread id */
	@NotNull
	private Long discussionThreadId;

	/** discussionThread title */
	private String discussionTitle;

	/** title */
	@Size(min = 1, max = 800)
	@NotNull
	private String content;

	/** date */
	private LocalDateTime date;

	/** edit */
	private boolean edit;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageDto [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", discussionThreadId=");
		builder.append(discussionThreadId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", date=");
		builder.append(date);
		builder.append(", edit=");
		builder.append(edit);
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the discussionThreadId
	 */
	public Long getDiscussionThreadId() {
		return discussionThreadId;
	}

	/**
	 * @param discussionThreadId the discussionThreadId to set
	 */
	public void setDiscussionThreadId(Long discussionThreadId) {
		this.discussionThreadId = discussionThreadId;
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
	 * @return the edit
	 */
	public boolean isEdit() {
		return edit;
	}

	/**
	 * @param edit the edit to set
	 */
	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	/**
	 * @return the userPseudo
	 */
	public String getUserPseudo() {
		return userPseudo;
	}

	/**
	 * @param userPseudo the userPseudo to set
	 */
	public void setUserPseudo(String userPseudo) {
		this.userPseudo = userPseudo;
	}

	/**
	 * @return the discussionTitle
	 */
	public String getDiscussionTitle() {
		return discussionTitle;
	}

	/**
	 * @param discussionTitle the discussionTitle to set
	 */
	public void setDiscussionTitle(String discussionTitle) {
		this.discussionTitle = discussionTitle;
	}

}
