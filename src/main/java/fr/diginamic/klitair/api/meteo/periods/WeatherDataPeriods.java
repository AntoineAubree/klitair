/**
 * 
 */
package fr.diginamic.klitair.api.meteo.periods;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * Representation of Weather Data for several day every 6hours from JSON
 * response
 * 
 * @author anton
 *
 */

public class WeatherDataPeriods {

	/** date */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonProperty("datetime")
	private LocalDateTime date;

	/** temperature */
	@JsonProperty("temp2m")
	private float temperature;

	/** weatherConditions */
	@JsonProperty("weather")
	private int weatherConditions;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherDataPeriods [date=");
		builder.append(date);
		builder.append(", temperature=");
		builder.append(temperature);
		builder.append(", weatherConditions=");
		builder.append(weatherConditions);
		builder.append("]");
		return builder.toString();
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
	public int getWeatherConditions() {
		return weatherConditions;
	}

	/**
	 * @param weatherConditions the weatherConditions to set
	 */
	public void setWeatherConditions(int weatherConditions) {
		this.weatherConditions = weatherConditions;
	}

}
