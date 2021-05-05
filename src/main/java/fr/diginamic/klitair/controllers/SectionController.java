/**
 * 
 */
package fr.diginamic.klitair.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.SectionDto;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.services.SectionService;

/**
 * @author StephanieMC
 *
 */

@RestController
@RequestMapping("/section")
public class SectionController {

	@Autowired
	private SectionService sectionService;

	@PostMapping
	public SectionDto create(@Valid @RequestBody SectionDto sectionDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException("wrong length of title (1min-80max)");
		}
		return sectionService.create(sectionDto);
	}

	@PutMapping
	public SectionDto update(@Valid @RequestBody SectionDto sectionDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return sectionService.update(sectionDto);
	}

	@GetMapping("{index}/{limit}")
	public Page<SectionDto> findAll(@PathVariable int index, @PathVariable int limit) {
		return sectionService.findAll(index, limit);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		sectionService.deleteById(id);
	}

	@PostMapping(path = "title")
	public boolean checkTitle(@RequestParam(name = "title") String title) {
		return sectionService.checkTitle(title);
	}

}
