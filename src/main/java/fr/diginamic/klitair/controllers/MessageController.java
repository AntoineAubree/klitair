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
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.entity.Message;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.services.MessageService;

/**
 * @author StephanieMC
 *
 */
@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping
	public Message create(@Valid @RequestBody Message message, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return messageService.create(message);
	}

	@GetMapping("{id}")
	public List<Message> findByDiscussionThread(@PathVariable Long id) {
		return messageService.findByDiscussionThread(id);
	}

	@GetMapping("/user/{id}")
	public List<Message> findByUser(@PathVariable Long id) {
		return messageService.findByUser(id);
	}

	@PutMapping
	public Message update(@Valid @RequestBody Message message, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return messageService.update(message);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		messageService.deleteById(id);
	}

}
