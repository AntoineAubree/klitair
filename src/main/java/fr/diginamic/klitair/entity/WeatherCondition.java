/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class WeatherCondition {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** number */
	private int number;

	/** state */
	@Column(length = 150, nullable = false)
	@Size(min = 1, max = 150)
	@NotNull
	private String state;
	
	/** state */
	@Column
	private String baliseIcon;

	/** weathers */
	@OneToMany(mappedBy = "weatherCondition")
	private Set<IndicatorHistory> indicatorHistory = new HashSet<IndicatorHistory>();

	/*
	 * Constructor WITHOUT params
	 */
	public WeatherCondition() {
	}

	/**
	 * @param number
	 * @param state
	 */
	public WeatherCondition(int number, @Size(min = 1, max = 150) @NotNull String state) {
		super();
		this.number = number;
		this.state = state;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherCondition [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
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

	/**
	 * @return the indicatorHistory
	 */
	public Set<IndicatorHistory> getIndicatorHistory() {
		return indicatorHistory;
	}

	/**
	 * @param indicatorHistory the indicatorHistory to set
	 */
	public void setIndicatorHistory(Set<IndicatorHistory> indicatorHistory) {
		this.indicatorHistory = indicatorHistory;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

}
