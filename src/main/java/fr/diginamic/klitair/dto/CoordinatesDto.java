/**
 * 
 */
package fr.diginamic.klitair.dto;

/**
 * @author Antoine
 *
 */
public class CoordinatesDto {

	private float longitude;
	private float latitude;

	public CoordinatesDto() {
	}

	public CoordinatesDto(float longitude, float latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoordinatesDto [longitude=");
		builder.append(longitude);
		builder.append(", latitude=");
		builder.append(latitude);
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

}
