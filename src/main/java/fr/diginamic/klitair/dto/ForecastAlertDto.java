/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import fr.diginamic.klitair.entity.ReceivedAlert;
import fr.diginamic.klitair.entity.Town;

/**
 * @author StephanieMC
 *
 */
public class ForecastAlertDto {

	/** date */
	@NotNull
	private LocalDateTime date;
	/** temperature min */
	private float temperatureMin;

	/** temperature max */
	private float temperatureMax;

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

	/** towns */
	@NotNull
	private Town town;

	/** Departement */
	@NotNull
	private String department;

	/** Region */
	@NotNull
	private String region;

	/** received alerts */
	private Set<ReceivedAlert> receivedAlerts = new HashSet<ReceivedAlert>();

	/**
	 * Constructor WITHOUT params
	 */
	public ForecastAlertDto() {
		
	}

	/**
	 * @param date
	 * @param temperatureMin
	 * @param temperatureMax
	 * @param o3
	 * @param pm10
	 * @param no2
	 * @param so2
	 * @param pm25
	 * @param town
	 * @param department
	 * @param region
	 * @param receivedAlerts
	 */
	public ForecastAlertDto(@NotNull LocalDateTime date, float temperatureMin, float temperatureMax,
			@Min(1) @Max(6) int o3, @Min(1) @Max(6) int pm10, @Min(1) @Max(6) int no2, @Min(1) @Max(6) int so2,
			@Min(1) @Max(6) int pm25, @NotNull Town town, @NotNull String department, @NotNull String region,
			Set<ReceivedAlert> receivedAlerts) {
		super();
		this.date = date;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.o3 = o3;
		this.pm10 = pm10;
		this.no2 = no2;
		this.so2 = so2;
		this.pm25 = pm25;
		this.town = town;
		this.department = department;
		this.region = region;
		this.receivedAlerts = receivedAlerts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForecastAlertDto [date=");
		builder.append(date);
		builder.append(", temperatureMin=");
		builder.append(temperatureMin);
		builder.append(", temperatureMax=");
		builder.append(temperatureMax);
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
		builder.append(", town=");
		builder.append(town);
		builder.append(", department=");
		builder.append(department);
		builder.append(", region=");
		builder.append(region);
		builder.append(", receivedAlerts=");
		builder.append(receivedAlerts);
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
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the receivedAlerts
	 */
	public Set<ReceivedAlert> getReceivedAlerts() {
		return receivedAlerts;
	}

	/**
	 * @param receivedAlerts the receivedAlerts to set
	 */
	public void setReceivedAlerts(Set<ReceivedAlert> receivedAlerts) {
		this.receivedAlerts = receivedAlerts;
	}
	
	
}
