/**
 * 
 */
package fr.diginamic.klitair.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	// TODO manage Valids
	public User create(@Valid @RequestBody User user, BindingResult br) {
		if (!br.getAllErrors().isEmpty()) {

			throw new BadRequestException();
		}

		return userService.create(user);
		// TODO ask Richard or Salim for the transactionnals
	}

	@GetMapping
	public User findByPseudo(@RequestBody UserFindOneDto userDto) {
		// TODO manage optionnals
		return userService.findByPseudo(userDto);

	}

}
