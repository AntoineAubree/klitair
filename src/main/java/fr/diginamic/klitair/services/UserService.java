/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.UserDto;
import fr.diginamic.klitair.entity.Address;
import fr.diginamic.klitair.entity.User;
import fr.diginamic.klitair.exceptions.AlreadyExistException;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.repository.UserRepository;

/**
 * @author StephanieMC
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TownService townService;

	public User create(UserDto userDto) {
		checkIfUserAvailable(userDto);
		User user = new User();
		userFactory(userDto, user);
		return userRepository.save(user);
	}

	public UserDto findByPseudo(UserDto userDto) {
		User user =  userRepository.findByPseudoAndPassword(userDto.getPseudo(), userDto.getPassword())
				.orElseThrow(() -> new BadRequestException());
		return userDtoFactory(userDto, user);
	}

	public User update(UserDto userDto) {
		if (userDto.getId() == null || userRepository.findById(userDto.getId()).isEmpty()) {
			throw new BadRequestException();
		}
		checkIfUserAvailable(userDto);
		User user = userRepository.findById(userDto.getId()).orElseThrow();
		userFactory(userDto, user);
		return userRepository.save(user);
	}

	public void deleteById(Long id) {
		if (id == null || userRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
		userRepository.deleteById(id);
	}

	public boolean checkPseudo(String pseudo) {
		boolean pseudoAvailable = false;
		if (userRepository.findByPseudo(pseudo).isEmpty()) {
			pseudoAvailable = true;
		}
		return pseudoAvailable;
	}

	public boolean checkEmail(String email) {
		boolean emailAvailable = false;
		if (userRepository.findByEmail(email).isEmpty()) {
			emailAvailable = true;
		}
		return emailAvailable;
	}

	/**
	 * @param user
	 */
	private void checkIfUserAvailable(UserDto userDto) {
		if (!checkPseudo(userDto.getPseudo())) {
			throw new AlreadyExistException("Pseudo not available");
		} else if (!checkEmail(userDto.getEmail())) {
			throw new AlreadyExistException("Email not available");
		}
	}

	/**
	 * @param userDto
	 * @param user
	 */
	private void userFactory(UserDto userDto, User user) {
		user.setPseudo(userDto.getPseudo());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		user.setBanned(userDto.isBanned());
		user.setAddress(new Address(userDto.getNbStreet(), userDto.getStreet()));
		user.setTown(townService.findByName(userDto.getTown()));
	}

	/**
	 * @param userDto
	 * @param user
	 */
	private UserDto userDtoFactory(UserDto userDto, User user) {
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
		// TODO set TownFav + ReceiedAlertsDTO + token
		return userDto;
	}

}
