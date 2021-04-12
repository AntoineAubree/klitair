package fr.diginamic.klitair.api.airquality;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation of key "sous_indice" from the JSON Response
 * 
 * @author anton
 *
 */
public class Pollutant {

	/** name */
	@JsonProperty("polluant_name")
	private String name;

	/** indice */
	@JsonProperty("indice")
	private String indice;

	/** value */
	@JsonProperty("valeur")
	private Short value;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pollutant [name=");
		builder.append(name);
		builder.append(", indice=");
		builder.append(indice);
		builder.append(", value=");
		builder.append(value);
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
	 * @return the indice
	 */
	public String getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(String indice) {
		this.indice = indice;
	}

	/**
	 * @return the value
	 */
	public Short getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Short value) {
		this.value = value;
	}

}
