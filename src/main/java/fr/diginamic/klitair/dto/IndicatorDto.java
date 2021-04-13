package fr.diginamic.klitair.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.diginamic.klitair.api.airquality.AirQualityData;

/**
 * 
 * @author StephanieMC
 *
 */

public class IndicatorDto {

	//////////////////////////////// TOWN ///////////////////////////////////////

	/** Town's name */
	@Size(min = 1, max = 200)
	@NotNull
	private String townName;

	/** Town's postCode */
	@Size(min = 5, max = 5)
	@NotNull
	private String TownPostCode;

	/** Town's population */
	@Min(0)
	private int population;

	///////////////////////////// INDICATORS //////////////////////////////////////

	private List<AirQualityData> airQualityDatas;

	private List<DailyWeatherIndicator> dailyWeatherIndicators;

	/////////////////////////// DATE ////////////////////////////////////////////

	private LocalDateTime date;

	/** constructor WITHOUT params */
	public IndicatorDto() {

	}

	/**
	 * @param townName
	 * @param townPostCode
	 * @param population
	 * @param airQualityDatas
	 * @param dailyWeatherIndicators
	 * @param date
	 */
	public IndicatorDto(@Size(min = 1, max = 200) @NotNull String townName,
			@Size(min = 5, max = 5) @NotNull String townPostCode, @Min(0) int population,
			List<AirQualityData> airQualityDatas, List<DailyWeatherIndicator> dailyWeatherIndicators,
			LocalDateTime date) {
		super();
		this.townName = townName;
		TownPostCode = townPostCode;
		this.population = population;
		this.airQualityDatas = airQualityDatas;
		this.dailyWeatherIndicators = dailyWeatherIndicators;
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicatorDto [townName=");
		builder.append(townName);
		builder.append(", TownPostCode=");
		builder.append(TownPostCode);
		builder.append(", population=");
		builder.append(population);
		builder.append(", airQualityDatas=");
		builder.append(airQualityDatas);
		builder.append(", dailyWeatherIndicators=");
		builder.append(dailyWeatherIndicators);
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
	 * @return the townPostCode
	 */
	public String getTownPostCode() {
		return TownPostCode;
	}

	/**
	 * @param townPostCode the townPostCode to set
	 */
	public void setTownPostCode(String townPostCode) {
		TownPostCode = townPostCode;
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
	 * @return the airQualityDatas
	 */
	public List<AirQualityData> getAirQualityDatas() {
		return airQualityDatas;
	}

	/**
	 * @param airQualityDatas the airQualityDatas to set
	 */
	public void setAirQualityDatas(List<AirQualityData> airQualityDatas) {
		this.airQualityDatas = airQualityDatas;
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
