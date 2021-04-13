package fr.diginamic.klitair.api.meteo.day;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * Reprensatation of Weather Data for 1 day from JSON Reponse
 * 
 * @author anton
 *
 */
public class WeatherDataDay {

	/** date */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonProperty("datetime")
	private LocalDateTime date;

	/** temperatureMin */
	@JsonProperty("tmin")
	private float temperatureMin;

	/** temperatureMin */
	@JsonProperty("tmax")
	private float temperatureMax;

	/** weatherConditions */
	@JsonProperty("weather")
	private int weatherConditions;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherDataDay [date=");
		builder.append(date);
		builder.append(", temperatureMin=");
		builder.append(temperatureMin);
		builder.append(", temperatureMax=");
		builder.append(temperatureMax);
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
	 * @return the temperatureMin
	 */
	public float getTemperatureMin() {
		return temperatureMin;
	}

	/**
	 * @param temperatureMin the temperatureMin to set
	 */
	public void setTemperatureMin(float temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	/**
	 * @return the temperatureMax
	 */
	public float getTemperatureMax() {
		return temperatureMax;
	}

	/**
	 * @param temperatureMax the temperatureMax to set
	 */
	public void setTemperatureMax(float temperatureMax) {
		this.temperatureMax = temperatureMax;
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
