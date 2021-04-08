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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author StephanieMC
 *
 */
@Entity
public class Department {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** code */
	@Column(length = 3, nullable = false)
	@Size(min = 2, max = 3)
	@NotNull
	private String code;

	/** name */
	@Column(length = 150, nullable = false)
	@Size(min = 1, max = 150)
	@NotNull
	private String name;

	/** region */
	@ManyToOne
	@JoinColumn(name = "id_region")
	@NotNull
	private Region region;

	/** towns */
	@OneToMany(mappedBy = "department")
	private Set<Town> towns = new HashSet<Town>();

	/*
	 * Constructor WITHOUT params
	 */
	public Department() {

	}

	/**
	 * constuctor WITH params
	 * 
	 * @param id
	 * @param code
	 * @param name
	 * @param region
	 */
	public Department(@Size(min = 2, max = 3) @NotNull String code, @Size(min = 1, max = 150) @NotNull String name) {
		super();
		this.code = code;
		this.name = name;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", region=");
		builder.append(region);
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
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the towns
	 */
	public Set<Town> getTowns() {
		return towns;
	}

	/**
	 * @param towns the towns to set
	 */
	public void setTowns(Set<Town> towns) {
		this.towns = towns;
	}

}
