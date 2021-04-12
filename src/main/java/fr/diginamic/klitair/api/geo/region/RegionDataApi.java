package fr.diginamic.klitair.api.geo.region;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of JSON response
 * 
 * @author anton
 *
 */
public class RegionDataApi {

	/** code */
	@JsonProperty("code")
	private String code;

	/** name */
	@JsonProperty("nom")
	private String name;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegionDataApi [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
