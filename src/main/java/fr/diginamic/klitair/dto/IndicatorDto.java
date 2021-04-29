package fr.diginamic.klitair.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author StephanieMC
 *
 */

public class IndicatorDto {

	@NotNull
	private Coordinate coordinate;

	//////////////////////////////// TOWN ///////////////////////////////////////

	/** Town's name */
	@Size(min = 1, max = 200)
	private String townName;

	/** Town's population */
	@Min(0)
	private int population;

	///////////////////////////// INDICATORS //////////////////////////////////////

	private List<DailyQualityIndicator> dailyQualityIndicator;

	private List<DailyWeatherIndicator> dailyWeatherIndicators;

	/////////////////////////// DATE ////////////////////////////////////////////

	private LocalDateTime date;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicatorDto [coordinate=");
		builder.append(coordinate);
		builder.append(", townName=");
		builder.append(townName);
		builder.append(", population=");
		builder.append(population);
		builder.append(", dailyQualityIndicator=");
		builder.append(dailyQualityIndicator);
		builder.append(", dailyWeatherIndicators=");
		builder.append(dailyWeatherIndicators);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	/**
	 * @param coordinate the coordinate to set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	/**
	 * @return the townName
	 */
	public String getTownName() {
		return townName;
	}

	/**
	 * @param townName the townName to set
	 */
	public void setTownName(String townName) {
		this.townName = townName;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * @return the dailyQualityIndicator
	 */
	public List<DailyQualityIndicator> getDailyQualityIndicator() {
		return dailyQualityIndicator;
	}

	/**
	 * @param dailyQualityIndicator the dailyQualityIndicator to set
	 */
	public void setDailyQualityIndicator(List<DailyQualityIndicator> dailyQualityIndicator) {
		this.dailyQualityIndicator = dailyQualityIndicator;
	}

	/**
	 * @return the dailyWeatherIndicators
	 */
	public List<DailyWeatherIndicator> getDailyWeatherIndicators() {
		return dailyWeatherIndicators;
	}

	/**
	 * @param dailyWeatherIndicators the dailyWeatherIndicators to set
	 */
	public void setDailyWeatherIndicators(List<DailyWeatherIndicator> dailyWeatherIndicators) {
		this.dailyWeatherIndicators = dailyWeatherIndicators;
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

}
