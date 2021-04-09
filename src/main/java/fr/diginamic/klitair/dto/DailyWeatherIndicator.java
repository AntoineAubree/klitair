package fr.diginamic.klitair.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author StephanieMC
 *
 */

public class DailyWeatherIndicator {

	/** temperature */
	private float temperature;

	/** date */
	@NotNull
	private LocalDateTime date;

	/** weatherConditions */
	@NotNull
	private String weatherConditions;
	
	
	/** constructor WITHOUT params*/
	
	public DailyWeatherIndicator() {
		
	}


	/**
	 * constructor WITH params
	 * @param temperature
	 * @param date
	 * @param weatherConditions
	 */
	public DailyWeatherIndicator(float temperature, @NotNull LocalDateTime date, @NotNull String weatherConditions) {
		super();
		this.temperature = temperature;
		this.date = date;
		this.weatherConditions = weatherConditions;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DailyWeatherIndicator [temperature=");
		builder.append(temperature);
		builder.append(", date=");
		builder.append(date);
		builder.append(", weatherConditions=");
		builder.append(weatherConditions);
		builder.append("]");
		return builder.toString();
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
	 * @return the weatherConditions
	 */
	public String getWeatherConditions() {
		return weatherConditions;
	}


	/**
	 * @param weatherConditions the weatherConditions to set
	 */
	public void setWeatherConditions(String weatherConditions) {
		this.weatherConditions = weatherConditions;
	}
	
	

}
