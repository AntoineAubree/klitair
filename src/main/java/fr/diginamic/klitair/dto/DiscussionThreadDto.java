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
public class DiscussionThreadDto {

	/** id */
	private Long id;

	/** user id */
	@NotNull
	private Long userId;

	/** section id */
	@NotNull
	private Long sectionId;

	/** title */
	@Size(min = 1, max = 80)
	@NotNull
	private String title;

	/** edit */
	private boolean edit;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TownDto [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
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
	 * @return the sectionId
	 */
	public Long getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId the sectionId to set
	 */
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

}
