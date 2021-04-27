/**
 * 
 */
package fr.diginamic.klitair.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.klitair.dto.UserDto;
import fr.diginamic.klitair.entity.Address;
import fr.diginamic.klitair.entity.User;
import fr.diginamic.klitair.services.TownService;

/**
 * @author Antoine
 *
 */
@Component
public class UserFactory {
	
	@Autowired
	private TownService townService;

	/**
	 * create user with userDto
	 * @param userDto
	 * @param user
	 */
	public User createUser(UserDto userDto) {
		User user = new User();
		addId(userDto, user); 
		user.setPseudo(userDto.getPseudo());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		user.setBanned(userDto.isBanned());
		user.setAddress(new Address(userDto.getNbStreet(), userDto.getStreet()));
		user.setTown(townService.findByName(userDto.getTown()));
		return user;
	}

	/**
	 * check if user already exist, if yes, add id to update user in database
	 * @param userDto
	 * @param user
	 */
	private void addId(UserDto userDto, User user) {
		if (userDto.getId() != null) {
			user.setId(userDto.getId());
		}
	}

}
