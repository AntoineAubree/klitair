/**
 * 
 */
package fr.diginamic.klitair.services;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.LoginDto;
import fr.diginamic.klitair.dto.UserDto;
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

	@Autowired
	private PostCodeService postCodeService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * create user from userDto, and save User in database
	 * 
	 * @param userDto
	 * @return userDto saved with id
	 */
	public UserDto create(UserDto userDto) {
		checkIfUserAvailable(userDto);
		return saveUser(userDto);
	}

	/**
	 * get user from userDto in database and update it
	 * 
	 * @param userDto
	 * @return userDto updated
	 */
	public UserDto update(UserDto userDto) {
		checkIfUserExist(userDto.getId());
		checkIfUserAvailable(userDto);
		return saveUser(userDto);
	}

	/**
	 * @param userDto
	 * @return
	 */
	private UserDto saveUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		user.setTown(townService.findByName(userDto.getTownName()));
		user.setPostCode(postCodeService.findByCode(userDto.getPostCodeCode()));
		user = userRepository.save(user);
		return modelMapper.map(user, UserDto.class);
	}

	/**
	 * @param index
	 * @param limit
	 * @return
	 */
	public Page<UserDto> findAll(int index, int limit) {
		Page<User> users = userRepository.findAll(PageRequest.of(index, limit));
		return new PageImpl<UserDto>(
				users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList()),
				users.getPageable(), users.getTotalElements());
	}

	/**
	 * find user and return userDto with pseudo and password if user is present in
	 * database, if not, throw BadRequestException
	 * 
	 * @param loginDto
	 * @return userDto
	 */
	public UserDto findByPseudo(LoginDto loginDto) {
		User user = userRepository.findByPseudoAndPassword(loginDto.getPseudo(), loginDto.getPassword())
				.orElseThrow(() -> new BadRequestException());
		return modelMapper.map(user, UserDto.class);
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new BadRequestException());
	}

	/**
	 * delete user with his id
	 * 
	 * @param id
	 */
	public void deleteById(Long id) {
		checkIfUserExist(id);
		userRepository.deleteById(id);
	}

	/**
	 * check if pseudo or email are not already used in database, throw
	 * AlreadyExistException if yes
	 * 
	 * @param userDto
	 */
	private void checkIfUserAvailable(UserDto userDto) {
		if (!checkPseudo(userDto.getPseudo())) {
			throw new AlreadyExistException("1|Pseudo not available");
		} else if (!checkEmail(userDto.getEmail())) {
			throw new AlreadyExistException("2|Email not available");
		}
	}

	/**
	 * check if pseudo is not already used in database
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
	 * check if email is not already used in database
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
	 * check if id of user is present in database, throw BadRequestException if not
	 * 
	 * @param userDto
	 */
	private void checkIfUserExist(Long id) {
		if (id == null || userRepository.findById(id).isEmpty()) {
			throw new BadRequestException();
		}
	}

}
