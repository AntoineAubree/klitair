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

import fr.diginamic.klitair.dto.UserDto;
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
	private UserService userService;

	@PostMapping
	public User create(@Valid @RequestBody UserDto userDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.create(userDto);
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
	public UserDto findByPseudo(@Valid @RequestBody UserDto userDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.findByPseudo(userDto);
	}

	@PutMapping
	public User update(@Valid @RequestBody UserDto userDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.update(userDto);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}

}
