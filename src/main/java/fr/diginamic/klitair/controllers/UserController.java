/**
 * 
 */
package fr.diginamic.klitair.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.klitair.dto.LoginDto;
import fr.diginamic.klitair.dto.UserDto;
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

	/**
	 * @param userDto
	 * @param br
	 * @return userDto
	 */
	@PostMapping
	@CrossOrigin
	public UserDto create(@Valid @RequestBody UserDto userDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.create(userDto);
	}

	/**
	 * @param userDto
	 * @param br
	 * @return userDto
	 */
	@PutMapping
	public UserDto update(@Valid @RequestBody UserDto userDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.update(userDto);
	}

	@GetMapping("{index}/{limit}")
	public Page<UserDto> findAll(@PathVariable int index, @PathVariable int limit) {
		return userService.findAll(index, limit);
	}

	/**
	 * @param loginDto
	 * @param br
	 * @return userDto
	 */
	@PostMapping(path = "/login")
	public UserDto login(@Valid @RequestBody LoginDto loginDto, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {
			throw new BadRequestException();
		}
		return userService.findByPseudo(loginDto);
	}

	/**
	 * @param id
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}

	/**
	 * @param pseudo
	 * @return true if pseudo is available and false if pseudo is already used
	 */
	@GetMapping(path = "/pseudo/{pseudo}")
	public boolean checkPseudo(@PathVariable String pseudo) {
		return userService.checkPseudo(pseudo);
	}

	/**
	 * @param email
	 * @return true if email is available and false if email is already used
	 */
	@GetMapping(path = "/email/{email}")
	public boolean checkEmail(@PathVariable String email) {
		return userService.checkEmail(email);
	}

}
