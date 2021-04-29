/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class Town {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** code */
	@Column(length = 5, nullable = false)
	@Size(min = 5, max = 5)
	@NotNull
	private String code;

	/** post codes */
	@ManyToMany
	@JoinTable(name = "town_post_code", joinColumns = @JoinColumn(name = "id_town", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_post_code", referencedColumnName = "id"))
	private List<PostCode> postCodes = new ArrayList<>();

	/** name */
	@Column(length = 200, nullable = false)
	@Size(min = 1, max = 200)
	@NotNull
	private String name;

	/** population */
	@Min(0)
	private int population;

	/** department */
	@ManyToOne
	@JoinColumn(name = "id_departement")
	private Department department;

	/** indicator history */
	@OneToMany(mappedBy = "town")
	private Set<IndicatorHistory> indicatorHistory = new HashSet<IndicatorHistory>();

	/** favourites */
	@OneToMany(mappedBy = "town")
	private Set<Favourite> favourites = new HashSet<Favourite>();

	/** users */
	@OneToMany(mappedBy = "town")
	private Set<User> users = new HashSet<User>();

	/** forecast alert */
	@OneToMany(mappedBy = "town")
	private Set<ForecastAlert> forecastAlerts = new HashSet<ForecastAlert>();

	public Town() {
	}

	/**
	 * @param code
	 * @param postCodes
	 * @param name
	 * @param population
	 */
	public Town(@Size(min = 5, max = 5) @NotNull String code, List<PostCode> postCodes,
			@Size(min = 1, max = 200) @NotNull String name, @Min(0) int population) {
		super();
		this.code = code;
		this.postCodes = postCodes;
		this.name = name;
		this.population = population;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Town [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", postCodes=");
		builder.append(postCodes);
		builder.append(", name=");
		builder.append(name);
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
	 * 
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
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
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
	 * @return the favourites
	 */
	public Set<Favourite> getFavourites() {
		return favourites;
	}

	/**
	 * @param favourites the favourites to set
	 */
	public void setFavourites(Set<Favourite> favourites) {
		this.favourites = favourites;
	}

	/**
	 * @return the forecasts
	 */
	public Set<ForecastAlert> getForecastAlerts() {
		return forecastAlerts;
	}

	/**
	 * @param forecasts the forecasts to set
	 */
	public void setForecastAlerts(Set<ForecastAlert> forecastAlerts) {
		this.forecastAlerts = forecastAlerts;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
	 * @return the postCodes
	 */
	public List<PostCode> getPostCodes() {
		return postCodes;
	}

	/**
	 * @param postCodes the postCodes to list
	 */
	public void setPostCodes(List<PostCode> postCodes) {
		this.postCodes = postCodes;
	}

}
