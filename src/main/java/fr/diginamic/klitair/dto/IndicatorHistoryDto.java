/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
public class IndicatorHistoryDto {

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

	private List<DailyIndicatorHistory> dailyIndicatorHistory;

/////////////////////////// DATE ////////////////////////////////////////////

	private LocalDateTime date;

	@NotNull
	private LocalDate startingDate;

	@NotNull
	private LocalDate endingDate;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicatorHistoryDto [townName=");
		builder.append(townName);
		builder.append(", population=");
		builder.append(population);
		builder.append(", dailyIndicatorHistory=");
		builder.append(dailyIndicatorHistory);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
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
	 * @return the dailyIndicatorHistory
	 */
	public List<DailyIndicatorHistory> getDailyIndicatorHistory() {
		return dailyIndicatorHistory;
	}

	/**
	 * @param dailyIndicatorHistory the dailyIndicatorHistory to set
	 */
	public void setDailyIndicatorHistory(List<DailyIndicatorHistory> dailyIndicatorHistory) {
		this.dailyIndicatorHistory = dailyIndicatorHistory;
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
	 * @return the startingDate
	 */
	public LocalDate getStartingDate() {
		return startingDate;
	}

	/**
	 * @param startingDate the startingDate to set
	 */
	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	/**
	 * @return the endingDate
	 */
	public LocalDate getEndingDate() {
		return endingDate;
	}

	/**
	 * @param endingDate the endingDate to set
	 */
	public void setEndingDate(LocalDate endingDate) {
		this.endingDate = endingDate;
	}

}
