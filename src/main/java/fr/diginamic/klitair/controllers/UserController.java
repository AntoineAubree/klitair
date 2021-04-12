/**
 * 
 */
package fr.diginamic.klitair.controllers;

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

import fr.diginamic.klitair.dto.UserFindOneDto;
import fr.diginamic.klitair.entity.User;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.services.UserService;

/**
 * @author StephanieMC
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.create(user);
		// TODO ask Richard or Salim for the transactionnals
	}
	
	@PostMapping(path = "pseudo")
	public boolean checkPseudo(@RequestParam(name = "pseudo") String pseudo) {
		return userService.checkPseudo(pseudo);
	}

	@PostMapping(path = "email")
	public boolean checkEmail(@RequestParam(name = "email") String email) {
		return userService.checkEmail(email);
	}

	@GetMapping
	public User findByPseudo(@Valid @RequestBody UserFindOneDto userDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.findByPseudo(userDto);
	}
	
	@PutMapping
	public User update(@Valid @RequestBody User user, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.update(user);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}

}
