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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Antoine
 *
 */
@Entity
public class PostCode {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** code */
	@Column(length = 5, nullable = false)
	@Size(min = 5, max = 5)
	@NotNull
	private String code;

	@ManyToMany
	@JoinTable(name = "town_post_code", joinColumns = @JoinColumn(name = "id_post_code", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_town", referencedColumnName = "id"))
	private Set<Town> towns = new HashSet<>();

	public PostCode() {
	}

	public PostCode(@Size(min = 5, max = 5) @NotNull String code) {
		super();
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostCode [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
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
