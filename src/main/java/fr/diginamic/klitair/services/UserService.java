/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.UserFindOneDto;
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
	UserRepository userRepository;

	public User create(User user) {
		checkIfUserAvailable(user);
		return userRepository.save(user);
	}

	public User findByPseudo(UserFindOneDto userDto) {
		return userRepository.findByPseudoAndPassword(userDto.getPseudo(), userDto.getPassword())
				.orElseThrow(() -> new BadRequestException());
	}

	public User update(User user) {
		if (user.getId() == null || userRepository.findById(user.getId()).isEmpty()) {
			throw new BadRequestException();
		}
		checkIfUserAvailable(user);
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
	private void checkIfUserAvailable(User user) {
		if (!checkPseudo(user.getPseudo())) {
			throw new AlreadyExistException("Pseudo not available");
		} else if (!checkEmail(user.getEmail())) {
			throw new AlreadyExistException("Email not available");
		}
	}

}
