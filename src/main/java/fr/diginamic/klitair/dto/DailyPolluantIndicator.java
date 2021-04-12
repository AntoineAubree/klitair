package fr.diginamic.klitair.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author StephanieMC
 *
 */

public class DailyPolluantIndicator {
	
	///////////////////** polluants */////////////////////
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

	/** date */
	@NotNull
	private LocalDate date;
	
	/** Constructor WITHOUT params */
	
	public DailyPolluantIndicator() {
		
	}

	/**
	 * contructor WITH params
	 * @param o3
	 * @param pm10
	 * @param no2
	 * @param so2
	 * @param pm25
	 * @param date
	 */
	public DailyPolluantIndicator(@Min(1) @Max(6) int o3, @Min(1) @Max(6) int pm10, @Min(1) @Max(6) int no2,
			@Min(1) @Max(6) int so2, @Min(1) @Max(6) int pm25, @NotNull LocalDate date) {
		super();
		this.o3 = o3;
		this.pm10 = pm10;
		this.no2 = no2;
		this.so2 = so2;
		this.pm25 = pm25;
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DailyPolluantIndicator [o3=");
		builder.append(o3);
		builder.append(", pm10=");
		builder.append(pm10);
		builder.append(", no2=");
		builder.append(no2);
		builder.append(", so2=");
		builder.append(so2);
		builder.append(", pm25=");
		builder.append(pm25);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
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
	
	
}
