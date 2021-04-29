/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antoine
 *
 */
public class TownDto {

	/** id */
	private Long id;

	/** name */
	@Size(min = 1, max = 200)
	@NotNull
	private String name;

	/** population */
	@Min(0)
	private int population;

	/** post codes */
	private List<String> postCodes;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TownDto [id=");
		builder.append(id);
		builder.append(", population=");
		builder.append(population);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
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
