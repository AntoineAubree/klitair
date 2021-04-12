package fr.diginamic.klitair.api.airquality;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * Representation of key "results" from the JSON Response
 * 
 * @author anton
 *
 */
public class ResultApi {

	/** date */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonProperty("date")
	private LocalDate date;

	/** nomCommune */
	@JsonProperty("commune_nom")
	private String nomCommune;

	/* codeInsee */
	@JsonProperty("commune")
	private String codeInsee;

	/* pollutans */
	@JsonProperty("sous_indice")
	private List<Pollutant> pollutans = new ArrayList<>();

	/**
	 * 
	 */
	public ResultApi() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResultApi [date=");
		builder.append(date);
		builder.append(", nomCommune=");
		builder.append(nomCommune);
		builder.append(", codeInsee=");
		builder.append(codeInsee);
		builder.append(", polluants=");
		builder.append(pollutans);
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
	 * @return the nomCommune
	 */
	public String getNomCommune() {
		return nomCommune;
	}

	/**
	 * @param nomCommune the nomCommune to set
	 */
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
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

	/**
	 * @return the pollutans
	 */
	public List<Pollutant> getPollutans() {
		return pollutans;
	}

	/**
	 * @param pollutans the pollutans to set
	 */
	public void setPollutans(List<Pollutant> pollutans) {
		this.pollutans = pollutans;
	}

}
