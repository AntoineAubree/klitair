/**
 * 
 */
package fr.diginamic.klitair.entity;

import javax.persistence.Embeddable;

/**
 * @author StephanieMC
 *
 */
@Embeddable
public class Address {
	
	private String nbStreet;
	private String street;
	private Town town;
	

}
