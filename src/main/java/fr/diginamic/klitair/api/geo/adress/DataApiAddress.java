/**
 * 
 */
package fr.diginamic.klitair.api.geo.adress;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of the JSON reponse from geo API adress
 * 
 * @author anton
 *
 */
public class DataApiAddress {

	/** features */
	@JsonProperty("features")
	private List<FeatureAddress> features = new ArrayList<>();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataApiAdress [features=");
		builder.append(features);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the features
	 */
	public List<FeatureAddress> getFeatures() {
		return features;
	}

	/**
	 * @param features the features to set
	 */
	public void setFeatures(List<FeatureAddress> features) {
		this.features = features;
	}

}
