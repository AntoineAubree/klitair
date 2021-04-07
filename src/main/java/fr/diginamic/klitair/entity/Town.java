/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(length = 5, nullable = false)
	@Size(min = 5, max = 5)
	@NotNull
	private String postCode;
	
	@Min(0)
	private int population;
	
	@ManyToOne
	@JoinColumn( name= "id_departement")
	private Department department;

	/**
	 * Constructor WITHOUT params
	 */
	public Town() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor WITH params
	 * @param code
	 * @param name
	 * @param postCode
	 * @param population
	 */
	public Town( @Size(min = 5, max = 5) @NotNull String code, @Size(min = 1, max = 200) @NotNull String name,
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
	
	
}
