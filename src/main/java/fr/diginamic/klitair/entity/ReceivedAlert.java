/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * @author StephanieMC
 *
 */
@Entity
public class ReceivedAlert {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** read */
	@Column(name = "is_read")
	private boolean read;

	/** user */
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotNull
	private User user;

	/** forecast alert */
	@ManyToOne
	@JoinColumn(name = "id_forecast_alert")
	@NotNull
	private ForecastAlert forecastAlert;

	public ReceivedAlert() {
	}

	public ReceivedAlert(boolean read) {
		super();
		this.read = read;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceivedAlert [id=");
		builder.append(id);
		builder.append(", read=");
		builder.append(read);
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
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * @param read the read to set
	 */
	public void setRead(boolean read) {
		this.read = read;
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
	 * @return the forecastAlert
	 */
	public ForecastAlert getForecastAlert() {
		return forecastAlert;
	}

	/**
	 * @param forecastAlert the forecastAlert to set
	 */
	public void setForecastAlert(ForecastAlert forecastAlert) {
		this.forecastAlert = forecastAlert;
	}

}
