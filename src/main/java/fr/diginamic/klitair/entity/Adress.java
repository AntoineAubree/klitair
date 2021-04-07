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
public class Adress {
	
	private String nbStreet;
	private String street;
	private Town town;
	

}
