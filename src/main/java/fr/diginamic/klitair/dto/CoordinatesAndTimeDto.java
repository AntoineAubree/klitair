/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.time.LocalDate;

/**
 * @author Antoine
 *
 */
public class CoordinatesAndTimeDto {

	private float longitude;
	private float latitude;
	private LocalDate startingDate;
	private LocalDate endingDate;

	public CoordinatesAndTimeDto() {
	}

	/**
	 * @param longitude
	 * @param latitude
	 * @param startingDate
	 * @param endingDate
	 */
	public CoordinatesAndTimeDto(float longitude, float latitude, LocalDate startingDate, LocalDate endingDate) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoordinatesAndTimeDto [longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", startingDate=");
		builder.append(startingDate);
		builder.append(", endingDate=");
		builder.append(endingDate);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
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
