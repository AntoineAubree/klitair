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
public class Message {
	
	private Long id;
	private String content;
	private LocalDateTime date;

}
