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
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.MessageDto;
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
	public MessageDto create(@Valid @RequestBody MessageDto messageDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return messageService.create(messageDto);
	}
	
	@PutMapping
	public MessageDto update(@Valid @RequestBody MessageDto messageDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return messageService.update(messageDto);
	}

	@GetMapping("{id}/{index}/{limit}")
	public Page<MessageDto> findByDiscussionThread(@PathVariable Long idDiscussionThread, @PathVariable int index, @PathVariable int limit) {
		return messageService.findByDiscussionThread(idDiscussionThread, index, limit);
	}

	@GetMapping("/user/{id}/{index}/{limit}")
	public Page<MessageDto> findByUser(@PathVariable Long idUser, @PathVariable int index, @PathVariable int limit) {
		return messageService.findByUser(idUser, index, limit);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		messageService.deleteById(id);
	}

}
