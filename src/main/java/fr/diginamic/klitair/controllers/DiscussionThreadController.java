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

import fr.diginamic.klitair.dto.DiscussionThreadDto;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.services.DiscussionThreadSrevice;

/**
 * @author StephanieMC
 *
 */

@RestController
@RequestMapping("/discussion_thread")
public class DiscussionThreadController {

	@Autowired
	private DiscussionThreadSrevice discussionThreadService;

	@PostMapping
	public DiscussionThreadDto create(@Valid @RequestBody DiscussionThreadDto discussionThreadDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return discussionThreadService.create(discussionThreadDto);
	}

	@PutMapping
	public DiscussionThreadDto update(@Valid @RequestBody DiscussionThreadDto discussionThreadDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return discussionThreadService.update(discussionThreadDto);
	}

	@GetMapping("{id}/{index}/{limit}")
	public Page<DiscussionThreadDto> findBySection(@PathVariable Long id, @PathVariable int index, @PathVariable int limit) {
		return discussionThreadService.findByIdSection(id, index, limit);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		discussionThreadService.deleteById(id);
	}

	@PostMapping(path = "title")
	public boolean checkTitle(@RequestParam(name = "title") String title) {
		return discussionThreadService.checkTitle(title);
	}

}
