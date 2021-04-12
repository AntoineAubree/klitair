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

/**
 * @author StephanieMC
 *
 */
@Entity
public class Weather {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** date */
	@Column(nullable = false)
	@NotNull
	private LocalDateTime date;

	/** temperature */
	private float temperature;

	/** weatherCondition */
	@ManyToOne
	@JoinColumn(name = "id_weather_condition")
	@NotNull
	private WeatherCondition weatherCondition;

	/** town */
	@ManyToOne
	@JoinColumn(name = "id_town")
	@NotNull
	private Town town;

	/**
	 * Constructor WITHOUT params
	 */
	public Weather() {
	}

	public Weather(@NotNull LocalDateTime date, float temperature) {
		super();
		this.date = date;
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Weather [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", temperature=");
		builder.append(temperature);
		builder.append(", weatherCondition=");
		builder.append(weatherCondition);
		builder.append(", town=");
		builder.append(town);
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
	 * @return the temperature
	 */
	public float getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the weatherConditions
	 */
	public WeatherCondition getWeatherConditions() {
		return weatherCondition;
	}

	/**
	 * @param weatherConditions the weatherConditions to set
	 */
	public void setWeatherConditions(WeatherCondition weatherCondition) {
		this.weatherCondition = weatherCondition;
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

}
