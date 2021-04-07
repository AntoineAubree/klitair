/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

/**
 * @author StephanieMC
 *
 */
@Entity
public class Weather {
	
	private Long id;
	private LocalDateTime date;
	private float temperature;

}
