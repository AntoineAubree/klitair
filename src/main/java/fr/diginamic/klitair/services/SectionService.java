/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.entity.Section;
import fr.diginamic.klitair.exceptions.AlreadyExistException;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.SectionRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;

	public Section create(Section section) {
		checkIfSectionAvailable(section);
		return sectionRepository.save(section);
	}

	public List<Section> findAll() {
		return sectionRepository.findAll();
	}

	public Section update(@Valid Section section) {
		if (section.getId() == null || sectionRepository.findById(section.getId()).isEmpty()) {
			throw new BadRequestException();
		}
		checkIfSectionAvailable(section);
		return sectionRepository.save(section);
	}

	public void deleteById(Long id) {
		if (id == null || sectionRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
		sectionRepository.deleteById(id);
	}
	
	public boolean checkTitle(String title) {
		boolean titleAvailable = false;
		if (sectionRepository.findByTitle(title).isEmpty()) {
			titleAvailable = true;
		}
		return titleAvailable;
	}
	
	/**
	 * @param section
	 */
	private void checkIfSectionAvailable(Section section) {
		if (!checkTitle(section.getTitle())) {
			throw new AlreadyExistException("Title not available");
		}
	}


}
