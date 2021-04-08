/**
 * 
 */
package fr.diginamic.klitair.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.diginamic.klitair.dto.UserFindOneDto;
import fr.diginamic.klitair.entity.User;
import fr.diginamic.klitair.exceptions.AlreadyExistException;
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
		if (!userRepository.findByPseudo(user.getPseudo()).isEmpty()) {
			throw new AlreadyExistException("Pseudo déja existant");
		}
		else if (!userRepository.findByEmail(user.getEmail()).isEmpty()) {
			throw new AlreadyExistException("Email déja existant");
		}


		return userRepository.save(user);
	}

	public User findByPseudo(UserFindOneDto userDto) {
//		return userRepository.findByPseudoAndPassword(userDto.getPseudo(), userDto.getPassword());
		return null;
	}

}
