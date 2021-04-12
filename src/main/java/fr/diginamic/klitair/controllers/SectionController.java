/**
 * 
 */
package fr.diginamic.klitair.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import fr.diginamic.klitair.entity.Section;
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
	SectionService sectionService;

	@PostMapping
	public Section create(@Valid @RequestBody Section section, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return sectionService.create(section);
	}
	
	@PostMapping(path = "title")
	public boolean checkTitle(@RequestParam(name = "title") String title) {
		return sectionService.checkTitle(title);
	}

	@GetMapping
	public List<Section> findAll() {
		return sectionService.findAll();
	}
	
	@PutMapping
	public Section update(@Valid @RequestBody Section section, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return sectionService.update(section);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		sectionService.deleteById(id);
	}

}
