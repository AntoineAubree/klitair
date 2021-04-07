/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

/**
 * @author StephanieMC
 *
 */
@Entity
public class AirQuality {
	
	private Long id;
	private LocalDate date;
	private int o3;
	private int pm10;
	private int no2;
	private int so2;
	private int pm25;

}
