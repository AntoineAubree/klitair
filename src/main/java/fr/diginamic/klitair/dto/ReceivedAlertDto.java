/**
 * 
 */
package fr.diginamic.klitair.dto;

/**
 * @author Antoine
 *
 */
public class ReceivedAlertDto {

	private Long id;

	private String content;

	public ReceivedAlertDto() {
	}

	/**
	 * @param id
	 * @param content
	 */
	public ReceivedAlertDto(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
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

}
