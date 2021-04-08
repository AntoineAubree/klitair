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
public class Section {
	
	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** title */
	@Column(length = 80, nullable = false)
	@Size(min = 1, max = 80)
	@NotNull
	private String title;

	/** user */
	@ManyToOne
	@JoinColumn(name = "id_user")
	@NotNull
	private User user;
	
	/** discussion thread */
	@OneToMany(mappedBy = "section")
	private Set<DiscussionThread> discussionThread = new HashSet<DiscussionThread>();
}
