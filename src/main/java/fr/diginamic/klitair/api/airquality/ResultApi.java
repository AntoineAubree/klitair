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

public class ResultApi {

	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonProperty("date")
	private LocalDate date;

	@JsonProperty("commune_nom")
	private String nomCommune;

	@JsonProperty("sous_indice")
	private List<Polluant> polluants = new ArrayList<>();

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
		builder.append(", polluants=");
		builder.append(polluants);
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
	 * @return the polluants
	 */
	public List<Polluant> getPolluants() {
		return polluants;
	}

	/**
	 * @param polluants the polluants to set
	 */
	public void setPolluants(List<Polluant> polluants) {
		this.polluants = polluants;
	}

}
