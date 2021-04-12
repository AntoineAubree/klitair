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

import fr.diginamic.klitair.entity.DiscussionThread;
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
	DiscussionThreadSrevice discussionThreadService;

	@PostMapping
	public DiscussionThread create(@Valid @RequestBody DiscussionThread discussionThread, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return discussionThreadService.create(discussionThread);
	}
	
	@PostMapping(path = "title")
	public boolean checkTitle(@RequestParam(name = "title") String title) {
		return discussionThreadService.checkTitle(title);
	}

	@GetMapping("{id}")
	public List<DiscussionThread> findBySection(@PathVariable Long id) {
		return discussionThreadService.findByIdSection(id);
	}
	
	@PutMapping
	public DiscussionThread update(@Valid @RequestBody DiscussionThread discussionThread, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return discussionThreadService.update(discussionThread);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		discussionThreadService.deleteById(id);
	}

}
