/**
 * 
 */
package fr.diginamic.klitair.api.geo.town;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reprensation of JSON reponse
 * 
 * @author anton
 *
 */
public class TownDataApi {

	/** code */
	@JsonProperty("code")
	private String code;

	/** name */
	@JsonProperty("nom")
	private String name;

	/** codeDepartement */
	@JsonProperty("codeDepartement")
	private String codeDepartement;

	/** postCodes */
	@JsonProperty("codesPostaux")
	private List<String> postCodes;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TownDataApi [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", codeDepartement=");
		builder.append(codeDepartement);
		builder.append(", postCodes=");
		builder.append(postCodes);
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

	/**
	 * @return the codeDepartement
	 */
	public String getCodeDepartement() {
		return codeDepartement;
	}

	/**
	 * @param codeDepartement the codeDepartement to set
	 */
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	/**
	 * @return the postCodes
	 */
	public List<String> getPostCodes() {
		return postCodes;
	}

	/**
	 * @param postCodes the postCodes to set
	 */
	public void setPostCodes(List<String> postCodes) {
		this.postCodes = postCodes;
	}

}
