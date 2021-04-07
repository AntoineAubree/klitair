/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Entity;

/**
 * @author StephanieMC
 *
 */
@Entity
public class Town {
	
	private Long id;
	private String code;
	private String name;
	private String postCode;
	private int population;

}
