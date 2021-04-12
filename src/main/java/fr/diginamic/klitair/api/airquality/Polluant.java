package fr.diginamic.klitair.api.airquality;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Polluant {

	@JsonProperty("polluant_name")
	private String nom;

	@JsonProperty("indice")
	private String indice;

	@JsonProperty("valeur")
	private Short valeur;

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
	 * @return the valeur
	 */
	public Short getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(Short valeur) {
		this.valeur = valeur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Polluant [nom=");
		builder.append(nom);
		builder.append(", indice=");
		builder.append(indice);
		builder.append(", valeur=");
		builder.append(valeur);
		builder.append("]");
		return builder.toString();
	}

}
