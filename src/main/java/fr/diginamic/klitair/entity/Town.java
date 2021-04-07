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
import javax.persistence.JoinColumn;
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

	/** name */
	@Column(length = 200, nullable = false)
	@Size(min = 1, max = 200)
	@NotNull
	private String name;

	/** postCode */
	@Column(name = "post_code", length = 5, nullable = false)
	@Size(min = 5, max = 5)
	@NotNull
	private String postCode;

	/** population */
	@Min(0)
	private int population;

	/** department */
	@ManyToOne
	@JoinColumn(name = "id_departement")
	private Department department;

	/** weathers */
	@OneToMany(mappedBy = "town")
	private Set<Weather> weathers = new HashSet<Weather>();

	/** air quality */
	@OneToMany(mappedBy = "town")
	private Set<Weather> airQuality = new HashSet<Weather>();

	/** favourites */
	@OneToMany(mappedBy = "town")
	private Set<Favourite> favourites = new HashSet<Favourite>();

	/** address */
	@OneToMany(mappedBy = "town")
	private Set<Address> address = new HashSet<Address>();

	/** town forecast alert */
	@OneToMany(mappedBy = "town")
	private Set<TownForecastAlert> forecasts = new HashSet<TownForecastAlert>();

	/**
	 * Constructor WITHOUT params
	 */
	public Town() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor WITH params
	 * 
	 * @param code
	 * @param name
	 * @param postCode
	 * @param population
	 */
	public Town(@Size(min = 5, max = 5) @NotNull String code, @Size(min = 1, max = 200) @NotNull String name,
			@Size(min = 5, max = 5) @NotNull String postCode, @Min(0) int population) {
		super();
		this.code = code;
		this.name = name;
		this.postCode = postCode;
		this.population = population;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Town [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", postCode=");
		builder.append(postCode);
		builder.append(", population=");
		builder.append(population);
		builder.append(", department=");
		builder.append(department);
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
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * @return the weathers
	 */
	public Set<Weather> getWeathers() {
		return weathers;
	}

	/**
	 * @param weathers the weathers to set
	 */
	public void setWeathers(Set<Weather> weathers) {
		this.weathers = weathers;
	}

	/**
	 * @return the airQuality
	 */
	public Set<Weather> getAirQuality() {
		return airQuality;
	}

	/**
	 * @param airQuality the airQuality to set
	 */
	public void setAirQuality(Set<Weather> airQuality) {
		this.airQuality = airQuality;
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
	public Set<TownForecastAlert> getForecasts() {
		return forecasts;
	}

	/**
	 * @param forecasts the forecasts to set
	 */
	public void setForecasts(Set<TownForecastAlert> forecasts) {
		this.forecasts = forecasts;
	}

	/**
	 * @return the address
	 */
	public Set<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Set<Address> address) {
		this.address = address;
	}

}
