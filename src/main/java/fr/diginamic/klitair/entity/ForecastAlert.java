/**
 * 
 */
package fr.diginamic.klitair.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;

/**
 * @author StephanieMC
 *
 */
@Entity
public class ForecastAlert {
	
	private Long id;
	private LocalDateTime date;
	private float temperature;
	private int o3;
	private int pm10;
	private int no2;
	private int so2;
	private int pm25;
	
	

}
