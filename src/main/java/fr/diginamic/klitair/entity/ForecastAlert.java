/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author StephanieMC
 *
 */
@Entity
public class ForecastAlert {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** date */
	@Column(nullable = false)
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

	/** received alerts */
	@OneToMany(mappedBy = "forecastAlert")
	private Set<ReceivedAlert> receivedAlerts = new HashSet<ReceivedAlert>();

	/** user */
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotNull
	private User user;

	/** towns */
	@ManyToOne
	@JoinColumn(name = "id_town")
	@NotNull
	private Town town;

	public ForecastAlert() {
	}

	public ForecastAlert(@NotNull LocalDateTime date, float temperatureMin, float temperatureMax,
			@Min(1) @Max(6) int o3, @Min(1) @Max(6) int pm10, @Min(1) @Max(6) int no2, @Min(1) @Max(6) int so2,
			@Min(1) @Max(6) int pm25) {
		super();
		this.date = date;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.o3 = o3;
		this.pm10 = pm10;
		this.no2 = no2;
		this.so2 = so2;
		this.pm25 = pm25;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ForecastAlert [id=");
		builder.append(id);
		builder.append(", date=");
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
