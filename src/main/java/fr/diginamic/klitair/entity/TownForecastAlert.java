/**
 * 
 */
package fr.diginamic.klitair.entity;

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
public class TownForecastAlert {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** send */
	private boolean send;

	/** town */
	@ManyToOne
	@JoinColumn(name = "id_town")
	@NotNull
	private Town town;

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

	public TownForecastAlert() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TownForecastAlert [id=");
		builder.append(id);
		builder.append(", send=");
		builder.append(send);
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
	 * @return the send
	 */
	public boolean isSend() {
		return send;
	}

	/**
	 * @param send the send to set
	 */
	public void setSend(boolean send) {
		this.send = send;
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
