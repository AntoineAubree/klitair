/**
 * 
 */
package fr.diginamic.klitair.factory;

import org.springframework.stereotype.Component;

import fr.diginamic.klitair.dto.ReceivedAlertDto;
import fr.diginamic.klitair.dto.UserDto;
import fr.diginamic.klitair.entity.Favourite;
import fr.diginamic.klitair.entity.ReceivedAlert;
import fr.diginamic.klitair.entity.User;

/**
 * @author Antoine
 *
 */
@Component
public class UserDtoFactory {

	/**
	 * create userDto with user
	 * @param userDto
	 * @param user
	 */
	public UserDto createUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setPseudo(user.getPseudo());
		userDto.setPassword(user.getPassword());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setRole(user.getRole());
		userDto.setBanned(user.isBanned());
		userDto.setNbStreet(user.getAddress().getNbStreet());
		userDto.setStreet(user.getAddress().getStreet());
		userDto.setTown(user.getTown().getName());
		userDto.setPostCode(user.getTown().getPostCodes().get(0).getCode());
		for (Favourite favourite : user.getFavourites()) {
			userDto.getFavouritesTowns().add(favourite.getTown().getName());
		}
		for (ReceivedAlert receivedAlert : user.getReceivedAlerts()) {
			// TODO change received alert content
			userDto.getReceivedAlerts()
					.add(new ReceivedAlertDto(receivedAlert.getId(), receivedAlert.getForecastAlert().toString()));
		}
		// TODO set token
		userDto.setToken("tokentokentest");
		return userDto;
	}

}
