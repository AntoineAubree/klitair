/**
 * 
 */
package fr.diginamic.klitair.api.geo.adress;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reprensentation of key "features" from JSON reponse
 * 
 * @author anton
 *
 */
public class FeatureAddress {

	/** properties */
	@JsonProperty("properties")
	private PropertiesAddress properties;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeatureAdress [properties=");
		builder.append(properties);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the properties
	 */
	public PropertiesAddress getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(PropertiesAddress properties) {
		this.properties = properties;
	}

}
