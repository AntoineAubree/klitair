/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class WeatherConditions {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** state */
	@Column(length = 150, nullable = false)
	@Size(min = 1, max = 150)
	@NotNull
	private String state;

	/*
	 * Constructor WITHOUT params
	 */
	public WeatherConditions() {
	}

	/*
	 * Constructor WITH params
	 */
	public WeatherConditions(@Size(min = 1, max = 150) @NotNull String state) {
		super();
		this.state = state;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherConditions [id=");
		builder.append(id);
		builder.append(", state=");
		builder.append(state);
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
