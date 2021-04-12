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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author StephanieMC
 *
 */
@Entity
public class Region {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** code */
	@Column(length = 3, nullable = false)
	@Size(min = 2, max = 3)
	@NotNull
	@JsonProperty("code")
	private String code;

	/** name */
	@Column(length = 150, nullable = false)
	@Size(min = 1, max = 150)
	@NotNull
	@JsonProperty("nom")
	private String name;

	/** departments */
	@OneToMany(mappedBy = "region")
	private Set<Department> departments = new HashSet<Department>();

	/**
	 * constructor WITHOUT params
	 */
	public Region() {

	}

	/**
	 * Constructor with params
	 * 
	 * @param code
	 * @param name
	 */
	public Region(@Size(min = 5, max = 5) @NotNull String code, @Size(min = 1, max = 150) @NotNull String name) {
		super();
		this.code = code;
		this.name = name;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Region [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", departments=");
		builder.append(departments);
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
	 * @return the departments
	 */
	public Set<Department> getDepartments() {
		return departments;
	}

	/**
	 * @param departments the departments to set
	 */
	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

}
