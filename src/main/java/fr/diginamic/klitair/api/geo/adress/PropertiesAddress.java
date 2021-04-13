/**
 * 
 */
package fr.diginamic.klitair.api.geo.adress;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of key "properties" from JSON response
 * 
 * @author anton
 *
 */
public class PropertiesAddress {

	/** cityCode */
	@JsonProperty("citycode")
	private String cityCode;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertiesAdress [cityCode=");
		builder.append(cityCode);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
