/**
 * 
 */
package fr.diginamic.klitair.api.geo.departement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of JSON response
 * 
 * @author anton
 *
 */
public class DepartmentDataApi {

	/** name */
	@JsonProperty("nom")
	private String name;

	/** code */
	@JsonProperty("code")
	private String code;

	/** codeRegion */
	@JsonProperty("codeRegion")
	private String codeRegion;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartmentDataApi [name=");
		builder.append(name);
		builder.append(", code=");
		builder.append(code);
		builder.append(", codeRegion=");
		builder.append(codeRegion);
		builder.append("]");
		return builder.toString();
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
	 * @return the codeRegion
	 */
	public String getCodeRegion() {
		return codeRegion;
	}

	/**
	 * @param codeRegion the codeRegion to set
	 */
	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

}
