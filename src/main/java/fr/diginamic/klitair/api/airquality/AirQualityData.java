/**
 * 
 */
package fr.diginamic.klitair.api.airquality;

import java.time.LocalDate;

/**
 * Representation of resume pollutant from the JSON reponse
 * 
 * @author anton
 *
 */
public class AirQualityData {

	/** date */
	private LocalDate date;

	/** o3 */
	private int o3;

	/** pm10 */
	private int pm10;

	/** no2 */
	private int no2;

	/** so2 */
	private int so2;

	/** pm25 */
	private int pm25;

	/** codeInsee */
	private String codeInsee;

	/**
	 * 
	 */
	public AirQualityData() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirQualityData [date=");
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
		builder.append(", codeInsee=");
		builder.append(codeInsee);
		builder.append("]");
		return builder.toString();
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
	 * @return the codeInsee
	 */
	public String getCodeInsee() {
		return codeInsee;
	}

	/**
	 * @param codeInsee the codeInsee to set
	 */
	public void setCodeInsee(String codeInsee) {
		this.codeInsee = codeInsee;
	}

}
