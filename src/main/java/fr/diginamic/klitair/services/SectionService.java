/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.SectionDto;
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
	private SectionRepository sectionRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	public SectionDto create(SectionDto sectionDto) {
		checkIfSectionAvailable(sectionDto);
		checkIfUserValide(sectionDto);
		return saveSection(sectionDto);
	}

	public SectionDto update(@Valid SectionDto sectionDto) {
		checkIfSectionExist(sectionDto.getId());
		checkIfSectionAvailable(sectionDto);
		checkIfUserValide(sectionDto);
		return saveSection(sectionDto);
	}

	/**
	 * @param sectionDto
	 * @return
	 */
	private SectionDto saveSection(SectionDto sectionDto) {
		Section section = modelMapper.map(sectionDto, Section.class);
		section = sectionRepository.save(section);
		return modelMapper.map(section, SectionDto.class);
	}

	public Page<SectionDto> findAll(int index, int limit) {
		Page<Section> sections = sectionRepository.findAll(PageRequest.of(index, limit));
		return new PageImpl<SectionDto>(sections.stream().map(section -> modelMapper.map(section, SectionDto.class))
				.collect(Collectors.toList()), sections.getPageable(), sections.getTotalElements());
	}

	public void deleteById(Long id) {
		checkIfSectionExist(id);
		sectionRepository.deleteById(id);
	}

	public boolean checkTitle(String title) {
		boolean titleAvailable = false;
		if (sectionRepository.findByTitle(title).isEmpty()) {
			titleAvailable = true;
		}
		return titleAvailable;
	}

	private void checkIfSectionAvailable(SectionDto sectionDto) {
		if (!checkTitle(sectionDto.getTitle())) {
			throw new AlreadyExistException("Title not available");
		}
	}

	/**
	 * @param sectionDto
	 */
	private void checkIfSectionExist(Long id) {
		if (id == null || sectionRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
	}

	/**
	 * @param sectionDto
	 */
	private void checkIfUserValide(SectionDto sectionDto) {
		if (sectionDto.getUserId() == null) {
			throw new BadRequestException();
		}
		userService.findById(sectionDto.getUserId());
	}

}
