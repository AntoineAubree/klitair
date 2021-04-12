/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author StephanieMC
 *
 */
@Entity
public class IndicatorHistory {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** date */
	@Column(nullable = false)
	@NotNull
	private LocalDate date;

	/** o3 */
	@Min(1)
	@Max(6)
	private int o3;

	/** pm10 */
	@Min(1)
	@Max(6)
	private int pm10;

	/** no2 */
	@Min(1)
	@Max(6)
	private int no2;

	/** so2 */
	@Min(1)
	@Max(6)
	private int so2;

	/** pm25 */
	@Min(1)
	@Max(6)
	private int pm25;

	/** temperature min */
	private float temperatureMin;

	/** temperature max */
	private float temperatureMax;

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
	public IndicatorHistory() {
	}

	public IndicatorHistory(@NotNull LocalDate date, @Min(1) @Max(6) int o3, @Min(1) @Max(6) int pm10,
			@Min(1) @Max(6) int no2, @Min(1) @Max(6) int so2, @Min(1) @Max(6) int pm25, float temperatureMin,
			float temperatureMax, @NotNull WeatherCondition weatherCondition) {
		super();
		this.date = date;
		this.o3 = o3;
		this.pm10 = pm10;
		this.no2 = no2;
		this.so2 = so2;
		this.pm25 = pm25;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.weatherCondition = weatherCondition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicatorHistory [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", o3=");
		builder.append(o3);
		builder.append(", pm10=");
		builder.append(pm10);
		builder.append(", no2=");
		builder.append(no2);
		builder.append(", so2=");
		builder.append(so2);
		builder.append(", pm25=");
		builder.append(pm25);
		builder.append(", temperatureMin=");
		builder.append(temperatureMin);
		builder.append(", temperatureMax=");
		builder.append(temperatureMax);
		builder.append(", weatherCondition=");
		builder.append(weatherCondition);
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
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the o3
	 */
	public int getO3() {
		return o3;
	}

	/**
	 * @param o3 the o3 to set
	 */
	public void setO3(int o3) {
		this.o3 = o3;
	}

	/**
	 * @return the pm10
	 */
	public int getPm10() {
		return pm10;
	}

	/**
	 * @param pm10 the pm10 to set
	 */
	public void setPm10(int pm10) {
		this.pm10 = pm10;
	}

	/**
	 * @return the no2
	 */
	public int getNo2() {
		return no2;
	}

	/**
	 * @param no2 the no2 to set
	 */
	public void setNo2(int no2) {
		this.no2 = no2;
	}

	/**
	 * @return the so2
	 */
	public int getSo2() {
		return so2;
	}

	/**
	 * @param so2 the so2 to set
	 */
	public void setSo2(int so2) {
		this.so2 = so2;
	}

	/**
	 * @return the pm25
	 */
	public int getPm25() {
		return pm25;
	}

	/**
	 * @param pm25 the pm25 to set
	 */
	public void setPm25(int pm25) {
		this.pm25 = pm25;
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
	public WeatherCondition getWeatherCondition() {
		return weatherCondition;
	}

	/**
	 * @param weatherConditions the weatherConditions to set
	 */
	public void setWeatherCondition(WeatherCondition weatherCondition) {
		this.weatherCondition = weatherCondition;
	}

}
