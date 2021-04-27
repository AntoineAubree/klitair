/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.UserDto;
import fr.diginamic.klitair.entity.User;
import fr.diginamic.klitair.exceptions.AlreadyExistException;
import fr.diginamic.klitair.exceptions.BadRequestException;
import fr.diginamic.klitair.factory.UserDtoFactory;
import fr.diginamic.klitair.factory.UserFactory;
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
	private UserFactory userFactory;

	@Autowired
	private UserDtoFactory userDtoFactory;

	/**
	 * @author Antoine create user from userDto, and save User in database
	 * 
	 * @param userDto
	 * @return userDto saved with id
	 */
	public UserDto create(UserDto userDto) {
		checkIfUserAvailable(userDto);
		User user = userFactory.createUser(userDto);
		user = userRepository.save(user);
		return userDtoFactory.createUserDto(user);
	}

	/**
	 * @author Antoine get user from userDto in database and update it
	 * 
	 * @param userDto
	 * @return userDto updated
	 */
	public UserDto update(UserDto userDto) {
		checkIfUserExist(userDto.getId());
		checkIfUserAvailable(userDto);
		User user = userFactory.createUser(userDto);
		user = userRepository.save(user);
		return userDtoFactory.createUserDto(user);
	}

	public Page<UserDto> findAll(int index, int limit) {
		Page<User> users = userRepository.findAll(PageRequest.of(index, limit));
		// TODO convert page<User> to page<UserDto>
		return null;
	}

	/**
	 * @author Antoine find user and return userDto with pseudo and password if user
	 *         is present in database, if not, throw BadRequestException
	 * @param userDto
	 * @return userDto
	 */
	public UserDto findByPseudo(UserDto userDto) {
		User user = userRepository.findByPseudoAndPassword(userDto.getPseudo(), userDto.getPassword())
				.orElseThrow(() -> new BadRequestException());
		return userDtoFactory.createUserDto(user);
	}

	/**
	 * @author Antoine delete user with his id
	 * @param id
	 */
	public void deleteById(Long id) {
		checkIfUserExist(id);
		userRepository.deleteById(id);
	}

	///////////// check ////////////////////

	/**
	 * @author Antoine check if pseudo or email are not already used in database,
	 *         throw AlreadyExistException if yes
	 * 
	 * @param userDto
	 */
	private void checkIfUserAvailable(UserDto userDto) {
		if (!checkPseudo(userDto.getPseudo())) {
			throw new AlreadyExistException("Pseudo not available");
		} else if (!checkEmail(userDto.getEmail())) {
			throw new AlreadyExistException("Email not available");
		}
	}

	/**
	 * @author Antoine check if pseudo is not already used in database
	 * 
	 * @param pseudo
	 * @return true if pseudo is available and false if pseudo is already used
	 */
	public boolean checkPseudo(String pseudo) {
		boolean pseudoAvailable = false;
		if (userRepository.findByPseudo(pseudo).isEmpty()) {
			pseudoAvailable = true;
		}
		return pseudoAvailable;
	}

	/**
	 * @author Antoine check if email is not already used in database
	 * 
	 * @param email
	 * @return true if email is available and false if email is already used
	 */
	public boolean checkEmail(String email) {
		boolean emailAvailable = false;
		if (userRepository.findByEmail(email).isEmpty()) {
			emailAvailable = true;
		}
		return emailAvailable;
	}

	/**
	 * @author Antoine check if id of user is present in database, throw
	 *         BadRequestException if not
	 * 
	 * @param userDto
	 */
	private void checkIfUserExist(Long id) {
		if (id == null || userRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
	}

}
